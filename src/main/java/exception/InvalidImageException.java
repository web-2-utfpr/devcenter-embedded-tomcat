package exception;

public class InvalidImageException extends BaseException {

    public InvalidImageException() {
        super(messages.getString("invalidImage"));
    }

}
