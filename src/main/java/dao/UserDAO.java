/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class UserDAO extends DAO {

    public static User Login(User user) {
        PrepararStatement("SELECT id, email FROM usuario WHERE nome = ? AND senha = ?");
        try {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Close();
        }
        return user;
    }

    public static User Register(User user) {
        PrepararStatement("INSERT INTO usuario (`nome`, `senha`, `email`) VALUES (?, ?, ?)");
        try {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Close();
        }
        return user;
    }

}
