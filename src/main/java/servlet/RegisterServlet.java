package servlet;

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
            resp.sendRedirect("feed");
            return;
        }
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        if (UsuarioService.Registrar(nome, email, senha)) {
            req.setAttribute("error", "Cadastrado com sucesso. Realize o login.");
            context.Dispatch("/login.jsp");
        } else {
            req.setAttribute("error", "Usuário e/ou email já cadastrado");
            context.Dispatch("/register.jsp");
        }
    }

}
