package exception;

public class InvalidPasswordException extends BaseException {

    public InvalidPasswordException() {
        super(messages.getString("invalidPassword"));
    }
    
}
