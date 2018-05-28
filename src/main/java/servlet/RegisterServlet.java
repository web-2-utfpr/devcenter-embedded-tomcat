package servlet;

import exception.UserAlreadyExistsException;
import util.Context;
import java.io.IOException;
import java.util.ResourceBundle;
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
        
        req.getRequestDispatcher("/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        context = new Context(req, resp);
        
        ResourceBundle messages = ResourceBundle.getBundle("Messages");
        
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
               
        if (nome == null || !(nome.matches("^[a-zA-Z]+[0-9]*$"))) {
            req.setAttribute("error", messages.getString("invalidName"));
            context.Dispatch("/register.jsp");
            return;
        }
        
        if (email == null || !(email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"))) {
            req.setAttribute("error", messages.getString("invalidEmail"));
            context.Dispatch("/register.jsp");
            return;
        }
        
        if (senha == null || senha.length() < 8 ) {
            req.setAttribute("error", messages.getString("invalidPassword"));
            context.Dispatch("/register.jsp");
            return;
        }
        
        
   //     ResourceBundle messages = ResourceBundle.getBundle("Messages");
        
        try {
            UsuarioService.registrar(nome, email, senha);
            req.setAttribute("msg", messages.getString("registerSuccess"));
    //        req.setAttribute("msg", messages.getString("register:success"));
            context.Dispatch("/login.jsp");
        } catch (UserAlreadyExistsException ex) {
            req.setAttribute("error", messages.getString("userAlreadyExists"));
            context.Dispatch("/register.jsp");
        }

    }

}
