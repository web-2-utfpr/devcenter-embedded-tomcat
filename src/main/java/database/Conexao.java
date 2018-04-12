/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
    public static Connection teste() {
        Connection con = null;
        System.out.println();
        try {
            
            if(System.getenv("MYSQL_HOST") != null) {
                con = DriverManager.getConnection(System.getenv("MYSQL_HOST"), System.getenv("MYSQL_USER"), System.getenv("MYSQL_PASSWORD"));
            } else {
                con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/instaclone", "root", "root");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
