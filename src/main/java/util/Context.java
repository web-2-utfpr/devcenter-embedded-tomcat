package util;

import model.bean.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Context {

    HttpServletRequest request;
    HttpServletResponse response;
    Usuario loggedUser;

    public Context(HttpServletRequest req, HttpServletResponse resp) {
        request = req;
        response = resp;
        loggedUser = (Usuario) request.getSession().getAttribute("loggedUser");
    }

    public boolean estaLogado() {
        return loggedUser != null;
    }

    public void setLoggedUser(Usuario loggedUser) {
        request.getSession(true).setAttribute("loggedUser", loggedUser);
        this.loggedUser = loggedUser;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void Dispatch(String page) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }

    public void Redirect(String page) throws IOException {
        response.sendRedirect(page);
    }

}
