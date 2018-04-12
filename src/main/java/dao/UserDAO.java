/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class UserDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static User Login(User user) {
        String searchQuery = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        PreparedStatement stmt = null;

        try {
            currentCon = Conexao.GetConnection();
            stmt = currentCon.prepareStatement(searchQuery);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.seteValido(true);
            } else {
                user.seteValido(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    rs = null;
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    stmt = null;
                }
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                currentCon = null;
            }

        }
        return user;
    }

    public static User Register(User user) {
        String searchQuery = "INSERT INTO usuario (`nome`, `senha`, `email`) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            currentCon = Conexao.GetConnection();
            stmt = currentCon.prepareStatement(searchQuery);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            user.seteValido(false);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    stmt = null;
                }
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                currentCon = null;
            }

        }
        user.seteValido(true);
        return user;
    }
}
