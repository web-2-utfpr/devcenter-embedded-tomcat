package servlet;

import dao.ImageDAO;
import entities.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

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
        
        req.setAttribute("images", ImageDAO.getPhotos(loggedUser));
        
        req.getRequestDispatcher("/logged.jsp").forward(req, resp);
    }

}
