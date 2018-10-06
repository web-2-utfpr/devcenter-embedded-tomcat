package servlet;

import exception.InvalidImageException;
import util.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.repository.ImageRepository;
import model.repository.UserRepository;
import util.FileHelper;
import util.imgur.Uploader;

@WebServlet(
        name = "Profile",
        urlPatterns = {"/profile"}
)
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class ProfileServlet extends HttpServlet {

    Context context;

    private static UserRepository userRepository;
    private static ImageRepository imageRepository;

    static {
        userRepository = new UserRepository();
        imageRepository = new ImageRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        String username = req.getParameter("u");

        if (username == null) {
            req.setAttribute("user", context.getLoggedUser());
            req.setAttribute("images", imageRepository.findByUser(context.getLoggedUser()));
        } else {
            try {
                Usuario user = userRepository.findByUsername(username);
                req.setAttribute("user", user);
                req.setAttribute("images", imageRepository.findByUser(user));
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
        try {
            imageRepository.newImage(context.getLoggedUser(), Uploader.upload(FileHelper.SaveImage(req.getPart("imagem"))));
        } catch (InvalidImageException e) {
            System.out.println(e.getMessage());
            req.setAttribute("error", e.getMessage());
        }
        context.Redirect("profile");
    }

}
