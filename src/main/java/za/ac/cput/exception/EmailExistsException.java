package za.ac.cput.exception;

/**
 * @Author Curstin Rose - 220275408
 * EmailExistsException.java
 * 2022/10/01
 */
public class EmailExistsException extends RuntimeException {
    public EmailExistsException() {
    }

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailExistsException(Throwable cause) {
        super(cause);
    }

    public EmailExistsException(String message,
                                Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
