package exception;

public class PasswordsNotMatchException extends BaseException {

    public PasswordsNotMatchException() {
        super(messages.getString("passwordsNotMatch"));
    }

}
