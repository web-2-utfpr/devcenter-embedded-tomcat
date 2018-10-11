package exception;

import java.util.ResourceBundle;

public abstract class BaseException extends Exception {

    protected static ResourceBundle messages;

    static {
        messages = ResourceBundle.getBundle("Messages");
    }

    protected BaseException(String message) {
        super(message);
    }
}
