package model.service;

import model.Usuario;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

public class UsuarioService {

    public static boolean Registrar(String nome, String email, String senha) {
        if (Usuario.findFirst("nome = ? OR email = ?", nome, email) != null) {
            return false;
        }

        Usuario user = new Usuario();
        user.set("nome", nome);
        user.set("senha", senha);
        user.set("email", email);
        return user.save();
    }

    public static Model Login(String nome, String senha) {
        return Usuario.findFirst("nome = ? AND senha = ?", nome, senha);
    }

    public static LazyList search(String username) {
        return Usuario.where("nome LIKE ?", "%" + username + "%");
    }
    
}
