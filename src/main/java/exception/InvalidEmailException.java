package exception;

public class InvalidEmailException extends BaseException {

    public InvalidEmailException() {
        super(messages.getString("invalidEmail"));
    }

}
