/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Database;
import util.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.service.ImagemService;

/**
 *
 * @author lucas
 */
@WebServlet(
        name = "Feed",
        urlPatterns = {"/feed"}
)
public class FeedServlet extends HttpServlet {

    Context context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);

        if (!context.estaLogado()) {
            context.Redirect("login");
            return;
        }

        String p = req.getParameter("p");

        try {
            int page = p != null ? Integer.parseInt(p) : 1;
            req.setAttribute("user", context.getLoggedUser());
            req.setAttribute("images", ImagemService.getAllPhotos(page));
            req.setAttribute("page", page);
        } catch (NumberFormatException e) {
            req.setAttribute("error", e.getMessage());
        }
        context.Dispatch("/feed.jsp");
    }

}
