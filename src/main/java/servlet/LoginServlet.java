package servlet;

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

        context = new Context(req, resp);

        if (context.estaLogado()) {
            resp.sendRedirect("feed");
            return;
        }

        context.Dispatch("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        if (context.estaLogado()) {
            resp.sendRedirect("feed");
            return;
        }

        Model user = UsuarioService.Login(req.getParameter("nome"), req.getParameter("senha"));

        if (user != null) {
            context.setLoggedUser(user);
            resp.sendRedirect("feed");
            return;
        }

        req.setAttribute("error", "Usuário e/ou senha incorreto(s)");
        context.Dispatch("/login.jsp");
    }

}
