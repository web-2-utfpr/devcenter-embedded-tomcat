package model.service;

import model.entity.User;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

public class UsuarioService {

    public static void registrar(String nome, String email, String senha) throws Exception {
        if (User.findFirst("nome = ? OR email = ?", nome, email) != null) {
            throw new Exception("Usuário e/ou email existentes.");
        }

        User user = new User();
        user.set("nome", nome);
        user.set("senha", senha);
        user.set("email", email);
        user.save();
    }

    public static Model login(String nome, String senha) throws Exception {
        Model user = findByUsername(nome);

        if (!user.getString("senha").equals(senha)) {
            throw new Exception("Senha incorreta");
        }

        return user;

    }

    public static LazyList search(String username) {
        return User.where("nome LIKE ?", "%" + username + "%");
    }

    public static Model findByUsername(String username) throws Exception {
        Model user = User.findFirst("nome = ?", username);
        if (user == null) {
            throw new Exception("Usuário " + username + " não encontrado");
        }
        return user;
    }

}
