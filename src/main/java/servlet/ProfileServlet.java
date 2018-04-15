package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.service.ImagemService;

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
        
        if (!context.estaLogado()) {
            req.setAttribute("error", "Efetue o login para visualizar essa pagina");
            context.Dispatch("/login.jsp");
            return;
        }
        
        String username = req.getParameter("u");
        
        if (username == null) {
            req.setAttribute("user", context.getLoggedUser());
            req.setAttribute("images", ImagemService.getByUserID(context.getLoggedUser().getLongId()));
        } else {
            req.setAttribute("user", new Usuario(username, "", ""));
            req.setAttribute("images", ImagemService.getPhotosByUsername(username));
        }
        
        context.Dispatch("/profile.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        context = new Context(req, resp);
        
        if (!context.estaLogado()) {
            resp.sendRedirect("login");
            return;
        }
        
        ImagemService.create(context.getLoggedUser().getLongId(), req.getPart("imagem"));
        
        resp.sendRedirect("profile");
        
    }
    
}
