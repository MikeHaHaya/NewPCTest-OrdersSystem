package app.core.exceptions;

public class OrderMenuException extends OrderSystemException {

    public OrderMenuException() {
    }

    public OrderMenuException(String message) {
        super(message);
    }

    public OrderMenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderMenuException(Throwable cause) {
        super(cause);
    }

    public OrderMenuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
