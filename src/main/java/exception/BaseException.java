package exception;

import java.util.ResourceBundle;

public class BaseException extends Exception {

    protected static ResourceBundle messages;

    static {
        messages = ResourceBundle.getBundle("Messages");
    }

    BaseException (String message) {
        super(message);
    }
}
