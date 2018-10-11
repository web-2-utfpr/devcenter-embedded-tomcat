package exception;

public class InvalidUsernameException extends BaseException {

    public InvalidUsernameException() {
        super(messages.getString("invalidName"));
    }

}
