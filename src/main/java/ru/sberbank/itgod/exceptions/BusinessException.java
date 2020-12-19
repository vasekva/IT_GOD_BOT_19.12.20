package ru.sberbank.itgod.exceptions;

/**
 * Базовое исключение приложения
 */
public class BusinessException extends Exception {
    public BusinessException() {
        super();
    }

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }
}
