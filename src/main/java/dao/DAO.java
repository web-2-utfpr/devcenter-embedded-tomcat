/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public abstract class DAO {

    private static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;

    static void Close() {
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

    static void PrepararStatement(String query) {
        try {
            currentCon = Conexao.GetConnection();
            stmt = currentCon.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
