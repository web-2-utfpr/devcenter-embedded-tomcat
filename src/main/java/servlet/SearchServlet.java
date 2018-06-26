/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import util.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.repository.UserRepository;

/**
 *
 * @author lucas
 */
@WebServlet(
        name = "Search",
        urlPatterns = {"/search"}
)
public class SearchServlet extends HttpServlet {

    Context context;

    private static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        context = new Context(req, resp);
        req.setAttribute("users", userRepository.search(req.getParameter("q")));
        req.setAttribute("q", req.getParameter("q"));
        context.Dispatch("/search.jsp");

    }

}
