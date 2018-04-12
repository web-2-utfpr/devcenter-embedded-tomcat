package servlet;

import model.dao.ImageDAO;
import model.entities.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "Images",
        urlPatterns = {"/image"}
)
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        User loggedUser = (User) req.getSession().getAttribute("loggedUser");
        
        if (loggedUser == null) {
            resp.sendRedirect("login");
            return;
        }
        
        req.setAttribute("user", loggedUser);
        req.setAttribute("images", ImageDAO.getPhotos(loggedUser));
        req.getRequestDispatcher("/logged.jsp").forward(req, resp);
    }
    
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        User loggedUser = (User) req.getSession().getAttribute("loggedUser");
        
        if (loggedUser == null) {
            resp.sendRedirect("login");
            return;
        }
        
        // UPAR IMAGEM
        
        // ADICIONAR NO BANCO
    }

}
