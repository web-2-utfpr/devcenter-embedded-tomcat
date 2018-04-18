package servlet;

import util.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.service.UsuarioService;

@WebServlet(
        name = "Registration",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {

    Context context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        if (context.estaLogado()) {
            resp.sendRedirect("feed");
        } else {
            context.Dispatch("/register.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        context = new Context(req, resp);

        if (context.estaLogado()) {
            context.Redirect("feed");
            return;
        }

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        try {
            UsuarioService.registrar(nome, email, senha);
            req.setAttribute("msg", "User registered. Do Login.");
            context.Dispatch("/login.jsp");
        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            context.Dispatch("/register.jsp");
        }

    }

}
