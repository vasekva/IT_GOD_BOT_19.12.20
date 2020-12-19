package ru.sberbank.itgod.exceptions;

/**
 * Исключение, полученное в ходе отправки или получения сообщения
 */
public class IntegrationException extends BusinessException {
    public IntegrationException() {
        super();
    }

    public IntegrationException(final String message) {
        super(message);
    }

    public IntegrationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IntegrationException(final Throwable cause) {
        super(cause);
    }
}
