package ru.sberbank.itgod.websocket;

import lombok.extern.slf4j.Slf4j;
import ru.sberbank.itgod.exceptions.IntegrationException;
import ru.sberbank.itgod.websocket.message.Message;
import ru.sberbank.itgod.enums.MsgType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Класс, сохраняющий в кэш сообщения от сервера и возвращающий их по запросу
 */
@Slf4j
public class AsyncListener {

	private static AsyncListener instance;
	private String gameId;

	/**
	 * Сообщения, полученные от сервера. Хэшмап, где ключ - тип сообщения, value - сообщение
	 * После прочтения нами сообщения, оно удаляется из хэшмап
	 */
	private static final Map<MsgType, Message> msgMap = new ConcurrentHashMap<>();

	/**
	 * Потоки, ожидающие информацию от сервера. Хэшмап, где ключ - тип сообщения, value - ожидающий его поток
	 */
	private static final Map<MsgType, Thread> waitingThreads = new ConcurrentHashMap<>();

	private AsyncListener() {
	}

	/**
	 * Получаем инстанс класса
	 */
	public static AsyncListener getInstance() {
		if (instance == null)
			instance = new AsyncListener();
		return instance;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(final String gameId) {
		this.gameId = gameId;
	}

	/**
	 * Проверяем, есть ли необходимые данные от сервера на запрос определенного типа.
	 * Если нет, поток встает в ожидание.
	 */
	//TODO написать кастомные эксепшены
	public Message getMessage(final MsgType msgType) throws IntegrationException {
		log.debug("Received request for message of type {}", msgType);
		if (msgMap.containsKey(msgType))
			return proceed(msgType);
		final Thread currentThread = Thread.currentThread();
		waitingThreads.put(msgType, currentThread);
		log.debug("Thread {} awaiting for message type {}", Thread.currentThread(), msgType);
		try {
			synchronized (currentThread) {
				currentThread.wait();
				waitingThreads.remove(msgType);
			}
		} catch (final InterruptedException e) {
			throw new IntegrationException(e);
		}
		if (!msgMap.containsKey(msgType))
			throw new IntegrationException("No server response for request");
		return proceed(msgType);
	}

	/**
	 * Получает сообщение определенного типа из кэша и удаляет его оттуда
	 */
	private Message proceed(final MsgType msgType) {
		final Message message = msgMap.get(msgType);
		msgMap.remove(msgType);
		log.debug("Got message from server: {}", message);
		return message;
	}

	/**
	 * Конвертируем полученные от сервера данные в Message и сохраняем его в хэшмапу по ключу MsgType.
	 * Если у нас висит поток, ожидающий этот тип сообщения от сервера, уведомляем его о получении.
	 * Если получаем сообщения типа GAME_OVER, завершаем программу.
	 */
	public void loadMessage(final String msg) {
		log.debug("Received new message from server: {}", msg);
		final Message message = MessageConverter.messageFromData(msg);

//		if (gameId != null && !gameId.equals(message.getGameId())) {
//			log.error("Requested game id {} and game id from server {} do not match!", gameId, message.getGameId());
//			return;
//		}

		final MsgType msgType = message.getMsgType();
		if (msgType.equals(MsgType.GAME_OVER) || msgType.equals(MsgType.GAME_CANCEL)) {
			System.exit(0);
		}
		msgMap.put(msgType, message);
		if (waitingThreads.containsKey(msgType)) {
			final Thread monitor = waitingThreads.get(msgType);
			synchronized (monitor) {
				log.debug("Thread {} notified", monitor);
				monitor.notify();
			}
		}
	}
}
