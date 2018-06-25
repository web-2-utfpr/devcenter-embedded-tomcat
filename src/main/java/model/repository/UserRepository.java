/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import exception.EmailAlreadyRegisteredException;
import exception.InvalidPasswordException;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import util.JWTUtil;

/**
 *
 * @author rafae
 */
public class UserRepository extends Repository {

    public String registrar(String nome, String email, String senha) throws UserAlreadyExistsException, EmailAlreadyRegisteredException {
        try {
            beginSession();
            transaction = session.beginTransaction();
            session.createNativeQuery("INSERT INTO users (nome, email, senha) VALUES (:nome, :email, :senha)")
                    .setParameter("nome", nome)
                    .setParameter("email", email)
                    .setParameter("senha", BCrypt.hashpw(senha, BCrypt.gensalt()))
                    .executeUpdate();
            transaction.commit();
            return JWTUtil.create(nome);
        } finally {
            closeSession();
        }
    }

    public String login(String nome, String senha) throws InvalidPasswordException, UserNotFoundException {
        try {
            beginSession();
            Usuario user = findByUsername(nome);
            if (BCrypt.checkpw(senha, user.getSenha())) {
                String token = JWTUtil.create(String.valueOf(user.getId()));
                return token;
            } else {
                throw new InvalidPasswordException();
            }
        } finally {
            closeSession();
        }
    }

    public List<Usuario> search(String username) {
        List<Usuario> users = new ArrayList<>();
        try {
            beginSession();
            JSONArray list = new JSONArray(session.createQuery("FROM Usuario AS u WHERE u.nome LIKE :nome")
                    .setParameter("nome", username + "%")
                    .list());
            for (Object obj : list) {
                users.add(setUser((JSONObject)(obj)));
            }
        } finally {
            closeSession();
        }
        return users;
    }

    public Usuario findByUsername(String username) throws UserNotFoundException {
        try {
            beginSession();
            JSONObject user = new JSONObject(session.createQuery("FROM Usuario AS u WHERE u.nome = :nome")
                    .setParameter("nome", username)
                    .list().get(0));
            return setUser(user);
        } finally {
            closeSession();
        }
    }

    public Usuario findById(Long id) throws UserNotFoundException {
        try {
            beginSession();
            JSONObject user = new JSONObject(session.createQuery("FROM Usuario AS u WHERE u.id = :id")
                    .setParameter("id", id)
                    .list().get(0));
            return setUser(user);
        } finally {
            closeSession();
        }
    }

    private Usuario setUser(JSONObject user) {
        Usuario u = new Usuario();
        u.setId(user.getLong("id"));
        u.setNome(user.getString("nome"));
        u.setEmail(user.getString("email"));
        u.setSenha(user.getString("senha"));
        return u;
    }
}
