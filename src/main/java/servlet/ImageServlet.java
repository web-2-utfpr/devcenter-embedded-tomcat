package servlet;

import controller.ImageController;
import controller.UserController;
import dao.ImageDAO;
import entities.Image;
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

    UserController uc;
    ImageController ic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        uc = new UserController(req, resp);

        if (!uc.estaLogado()) {
            resp.sendRedirect("login");
            return;
        }

        ic = new ImageController(req, resp);

        req.setAttribute("user", uc.getLoggedUser());
        req.setAttribute("images", ic.getByUserID(uc.getLoggedUser().getId()));

        ic.Dispatch("/logged.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        uc = new UserController(req, resp);

        if (!uc.estaLogado()) {
            resp.sendRedirect("login");
            return;
        }

        ic = new ImageController(req, resp);
        
        ic.create(uc.getLoggedUser().getId());

        resp.sendRedirect("image");

    }

}
