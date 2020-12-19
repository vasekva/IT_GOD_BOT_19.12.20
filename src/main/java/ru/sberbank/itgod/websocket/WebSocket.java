package ru.sberbank.itgod.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@Slf4j
@ClientEndpoint(decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class WebSocket {

    private AsyncListener asyncListener;
    private Session session;
    private final MessageDecoder decoder = new MessageDecoder();

    public WebSocket(final URI endpointURI) {
        final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            container.connectToServer(this, endpointURI);
            asyncListener = AsyncListener.getInstance();
            log.info("Websocket initialized. URI: {}", endpointURI);
        } catch (final DeploymentException | IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Логика при открытии сокета
     */
    @OnOpen
    public void onOpen(final Session session) {
        this.session = session;
        log.info("Connection opened");
    }

	/**
	 * Получение сообщения от сервера
	 */
	@OnMessage
	public void onMessage(Session session, byte[] m) {
		final String message = decoder.decode(new String(m));
		log.info(message);
		asyncListener.loadMessage(message);
	}

    /**
     * Логика при закрытии
     */
    @OnClose
    public void onClose() {
        AsyncSender.destroySender();
        log.info("Connection closed");
    }

    /**
     * Логика при ошибке
     */
    @OnError
    public void onError(final Session session, final Throwable e) {
        log.error("Websocket error", e);
    }

    /**
     * Отправка сообщения серверу
     */
    public void sendMessage(final String message) {
        try {
            log.info("Request: {}", message);
            session.getBasicRemote().sendObject(message);
        } catch (final EncodeException | IOException e) {
            log.error("SendMessage error. Message: {}", message, e);
        }
    }
}
