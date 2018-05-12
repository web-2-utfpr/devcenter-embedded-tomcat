package servlet;

import util.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.service.ImagemService;
import model.service.UsuarioService;
import org.javalite.activejdbc.Model;

@WebServlet(
        name = "Profile",
        urlPatterns = {"/profile"}
)
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class ProfileServlet extends HttpServlet {

    Context context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        String username = req.getParameter("u");

        if (username == null) {
            req.setAttribute("user", context.getLoggedUser());
        } else {
            try {
                Model user = UsuarioService.findByUsername(username);
                req.setAttribute("user", user);
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
            }
        }
        context.Dispatch("/profile.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        ImagemService.newImage(context.getLoggedUser().getLongId(), req.getPart("imagem"));
        
        context.Redirect("profile");

    }

}
