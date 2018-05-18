package servlet;

import util.Context;
import java.io.IOException;
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
        try {
            Model user = UsuarioService.login(req.getParameter("nome"), req.getParameter("senha"));
            context.setLoggedUser(user);
            resp.sendRedirect("feed");
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            context.Dispatch("/login.jsp");
        }
        
    }
}