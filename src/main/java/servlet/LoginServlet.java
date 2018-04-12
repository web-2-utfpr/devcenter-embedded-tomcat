package servlet;

import dao.UserDAO;
import entities.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "Authentication",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (req.getSession().getAttribute("loggedUser") == null) {
           req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("image");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = new User();
        user.setNome(req.getParameter("nome"));
        user.setSenha(req.getParameter("senha"));

        user = UserDAO.Login(user);

        if (user.eValido()) {
            HttpSession session = req.getSession(true);
            session.setAttribute("loggedUser", user);
            resp.sendRedirect("image");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    

}
