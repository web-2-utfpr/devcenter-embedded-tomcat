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
import model.service.UsuarioService;
import org.javalite.activejdbc.Model;

@WebServlet(
        name = "Login",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    
    private static final String USER_NOT_REGISTERED = "userNotRegistered";
    private static final String USER_WRONG_PASSWORD = "userWrongPassword";
            
    Context context;
    ResourceBundle messages = ResourceBundle.getBundle("Messages");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        context = new Context(req, resp);
        try {
            Model user = UsuarioService.login(req.getParameter("username"), req.getParameter("password"));
            context.setLoggedUser(user);
            resp.sendRedirect("feed");
        } catch (UserNotFoundException ex) {
            req.setAttribute("error", messages.getString(USER_NOT_REGISTERED));
            context.Dispatch("/login.jsp");
        } catch (InvalidPasswordException ex) {
            req.setAttribute("error", messages.getString(USER_WRONG_PASSWORD));
            context.Dispatch("/login.jsp");
        }
        
    }
}