package ru.sberbank.itgod.websocket;

import ru.sberbank.itgod.mechanics.actions.GameAction;
import ru.sberbank.itgod.websocket.message.model.EndPoint;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Класс для асинхронной отправки сообщений на веб сокет
 */
public class AsyncSender {
    private static AsyncSender instance;

    private final Queue<GameAction> queueToSend = new LinkedBlockingDeque<>();
    private Thread senderThread;
    private final WebSocket webSocket;

    private final String game;
    private final EndPoint server;

    private AsyncSender(final WebSocket webSocket, final String game, final EndPoint server) {
        this.webSocket = webSocket;
        this.game = game;
        this.server = server;
    }

    /**
     * Инициализация отправителя
     */
    public static void initSender(final WebSocket webSocket, final String game, final EndPoint server) {
        destroySender();
        instance = new AsyncSender(webSocket, game, server);
        instance.senderThread = new Thread(() -> instance.run());
        instance.senderThread.start();
    }

    /**
     * Уничтожает текущий сендер
     */
    public static void destroySender() {
        if (instance != null) {
            instance.senderThread.interrupt();
            instance = null;
        }
    }

    /**
     * Получает инстанс отправителя асинхронных сообщений, необходима предварительная инициализация @see initSender
     */
    public static AsyncSender getInstance() {
        return instance;
    }

    /**
     * Положить событие в очередь на отправку
     *
     * @param action - игровое событие
     */
    public void put(final GameAction action) {
        queueToSend.add(action);
    }

    /**
     * Формирует и отправляет сообщение по веб сокету
     *
     * @param action - игровое событие
     */
    private void send(final GameAction action) {
        final String message = MessageConverter.dataFromAction(action, game, server);
        webSocket.sendMessage(message);
    }

    /**
     * Метод запускает бесконечный цикл отправки сообщений из очереди на отправку
     * Необходимо запускать в отдельном потоке для реализации асинхронного взаимодействия
     */
    private void run() {
        final Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            final GameAction action = queueToSend.poll();
            if (action != null)
                send(action);
        }
    }

}
