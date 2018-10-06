package servlet;

import exception.InvalidPasswordException;
import exception.UserNotFoundException;
import util.Context;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.repository.UserRepository;

@WebServlet(
        name = "Login",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    private static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    Context context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Usuario user = userRepository.login2(username, password);
            context.setLoggedUser(user);
            resp.sendRedirect("feed");
        } catch (UserNotFoundException ex) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("error", ex.getMessage());
            context.Dispatch("/login.jsp");
        } catch (InvalidPasswordException ex) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("error", ex.getMessage());
            context.Dispatch("/login.jsp");
        }

    }
}
