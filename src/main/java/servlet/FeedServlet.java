package servlet;

import util.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.repository.ImageRepository;

@WebServlet(
        name = "Feed",
        urlPatterns = {"/feed"}
)
public class FeedServlet extends HttpServlet {

    Context context;

    private static ImageRepository imageRepository;
    private static int PAGESIZE = 3;

    static {
        imageRepository = new ImageRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String p = req.getParameter("p");
        context = new Context(req, resp);

        try {
            int page = p != null ? Integer.parseInt(p) : 1;
            req.setAttribute("user", context.getLoggedUser());
            req.setAttribute("images", imageRepository.getAllPhotos(page * PAGESIZE, PAGESIZE));
            req.setAttribute("page", page);
        } catch (NumberFormatException e) {
            req.setAttribute("error", e.getMessage());
        }
        context.Dispatch("/feed.jsp");

    }
}
