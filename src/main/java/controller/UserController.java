package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UserDAO;
import model.entities.User;

public class UserController extends Controller {

    User loggedUser;

    public UserController(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
        loggedUser = (User) request.getSession().getAttribute("loggedUser");
    }

    public boolean estaLogado() {
        return loggedUser != null;
    }

    public User getLoggedUser() {
        return loggedUser; 
    }

    public boolean Registrar() {
        User user = new User();
        user.setNome(request.getParameter("nome"));
        user.setSenha(request.getParameter("senha"));
        user.setEmail(request.getParameter("email"));

        user = UserDAO.Register(user);
        return ValidaUser(user);
    }

    public boolean Login() {
        User user = new User();
        user.setNome(request.getParameter("nome"));
        user.setSenha(request.getParameter("senha"));

        user = UserDAO.Login(user);
        return ValidaUser(user);
    }

    private boolean ValidaUser(User user) {
        if (user.eValido()) {
            request.getSession(true).setAttribute("loggedUser", user);
        }
        return user.eValido();
    }

}
