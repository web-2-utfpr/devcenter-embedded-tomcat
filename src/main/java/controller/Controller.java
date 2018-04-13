package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {

    HttpServletRequest request;
    HttpServletResponse response;

    Controller(HttpServletRequest req, HttpServletResponse resp) {
        request = req;
        response = resp;
    }

    public void Dispatch(String page) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }
}
