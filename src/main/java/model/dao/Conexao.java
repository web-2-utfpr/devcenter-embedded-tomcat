/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class Conexao {

    static Connection con;

    public static Connection GetConnection() {
        String db = System.getenv("MYSQL_HOST");
        String user;
        String password;

        if (db != null) {
            user = System.getenv("MYSQL_USER");
            password = System.getenv("MYSQL_PASSWORD");
        } else {
            db = "jdbc:mysql://192.168.99.100:3306/sql10232125?useSSL=false";
            user = "root";
            password = "root";
        }

        try {
            con = DriverManager.getConnection(db, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
