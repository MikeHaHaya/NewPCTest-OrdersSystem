package app.core.exceptions;

public class OrderSystemException extends Exception {

    public OrderSystemException() {
    }

    public OrderSystemException(String message) {
        super(message);
    }

    public OrderSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderSystemException(Throwable cause) {
        super(cause);
    }

    public OrderSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
