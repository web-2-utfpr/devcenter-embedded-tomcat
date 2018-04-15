package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Database;
import org.javalite.activejdbc.Model;

public class Context {
    HttpServletRequest request;
    HttpServletResponse response;
    
    Model loggedUser;

    Context(HttpServletRequest req, HttpServletResponse resp) {
        request = req;
        response = resp;
        Database.Open();
        loggedUser = (Model) request.getSession().getAttribute("loggedUser");
    }
    
    public boolean estaLogado() {
        return loggedUser != null;
    }

    public void setLoggedUser(Model loggedUser) {
        request.getSession(true).setAttribute("loggedUser", loggedUser);
        this.loggedUser = loggedUser;
    }

    public Model getLoggedUser() {
        return loggedUser;
    }
    
    public void Dispatch(String page) throws ServletException, IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }
    
}
