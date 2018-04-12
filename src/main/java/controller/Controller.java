/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafae
 */
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
