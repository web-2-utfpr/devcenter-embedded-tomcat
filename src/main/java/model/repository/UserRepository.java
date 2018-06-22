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
import model.bean.User;

/**
 *
 * @author rafae
 */
public class UserRepository extends Repository {

    public void registrar(String nome, String email, String senha) throws UserAlreadyExistsException, EmailAlreadyRegisteredException {
        try {
            beginSession();
        } finally {
            closeSession();
        }
    }

    public String login(String nome, String senha) throws InvalidPasswordException, UserNotFoundException {
        User user = null;
        try {
            beginSession();

        } finally {
            closeSession();
        }

        if (!user.getSenha().equals(senha)) {
            throw new InvalidPasswordException();
        }

        return "token";

    }

    public List<User> search(String username) {
        List<User> users = new ArrayList<>();
        try {
            beginSession();
        } finally {
            closeSession();
        }
        return users;
    }

    public Object findByUsername(String username) throws UserNotFoundException {
        try {
            beginSession();
            return session.createQuery("FROM User AS u WHERE u.nome = :nome", User.class)
                    .setParameter("nome", username)
                    .getSingleResult();
        } finally {
            closeSession();
        }
    }
}
