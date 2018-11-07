package servlet;

import model.bean.Image;
import model.repository.ImageRepository;
import util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "Feed",
        urlPatterns = {"/feed"}
)
public class FeedServlet extends HttpServlet {

    Context context;

    private static ImageRepository imageRepository;
    private static int PAGESIZE = 9;

    static {
        imageRepository = new ImageRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String p = req.getParameter("p");
        context = new Context(req, resp);

        boolean hasNextPage;

        try {
            long totalImages = imageRepository.imageQuantity();
            long lastPage = totalImages / PAGESIZE;

            int page = p != null ? Integer.parseInt(p) : 0;
            page = page < 0 ? 0 : page > lastPage ? (int) lastPage : page;

            List<Image> images = imageRepository.getAllPhotos(page * PAGESIZE, PAGESIZE);

            hasNextPage = totalImages > ((page + 1) * PAGESIZE);

            req.setAttribute("user", context.getLoggedUser());
            req.setAttribute("images", images);
            req.setAttribute("page", page);
            req.setAttribute("hasNextPage", hasNextPage);
        } catch (NumberFormatException e) {
            req.setAttribute("error", e.getMessage());
        }
        context.Dispatch("/feed.jsp");

    }
}
