package servlet;

import exception.EmailAlreadyRegisteredException;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import exception.InvalidUsernameException;
import exception.UserAlreadyExistsException;
import util.Context;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.repository.UserRepository;
import validator.EmailValidator;
import validator.PasswordValidator;
import validator.UsernameValidator;

@WebServlet(
        name = "Registration",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {

    Context context;

    private static final String PASSWORDS_NOT_MATCH = "passwordsNotMatch";

    private static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        ResourceBundle messages = ResourceBundle.getBundle("Messages");

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");

        try {
            if (!password.equals(confirm_password)) throw new InvalidPasswordException(messages.getString(PASSWORDS_NOT_MATCH));
            userRepository.registrar(username, email, password);
            req.setAttribute("msg", messages.getString("registerSuccess"));
            context.Dispatch("/login.jsp");
        } catch (UserAlreadyExistsException ex) {
            req.setAttribute("error", messages.getString("userAlreadyExists"));
            context.Dispatch("/register.jsp");
        } catch (EmailAlreadyRegisteredException ex) {
            req.setAttribute("error", messages.getString("emailInUse"));
            context.Dispatch("/register.jsp");
        } catch (InvalidUsernameException ex) {
            req.setAttribute("error", messages.getString("invalidName"));
            context.Dispatch("/register.jsp");
        } catch (InvalidEmailException ex) {
            req.setAttribute("error", messages.getString("invalidEmail"));
            context.Dispatch("/register.jsp");
        } catch (InvalidPasswordException ex) {
            req.setAttribute("error", messages.getString("invalidPassword"));
            context.Dispatch("/register.jsp");
        }

    }

}
