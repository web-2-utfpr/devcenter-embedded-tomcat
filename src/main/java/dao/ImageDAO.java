/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Image;
import entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class ImageDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static Map getPhotos(User user) {
        String searchQuery = "SELECT url, create_time FROM imagem WHERE id_usuario = ? ORDER BY create_time";
        PreparedStatement stmt = null;
        Map<String, Date> urls = new HashMap();
        try {
            currentCon = Conexao.GetConnection();
            stmt = currentCon.prepareStatement(searchQuery);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                System.out.println(rs.getDate("create_time"));
                urls.put(rs.getString("url"), rs.getDate("create_time"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                currentCon = null;
            }
            
        }
        return urls;
    }
    
    public static Image createImage(Image image){
        String searchQuery = "INSERT INTO imagem (`id_usuario`, `url`, `path`) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            currentCon = Conexao.GetConnection();
            stmt = currentCon.prepareStatement(searchQuery);
            stmt.setInt(1, image.getId_usuario());
            stmt.setString(2, image.getUrl());
            stmt.setString(3, image.getPath());
            System.out.println(stmt.toString());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return image;
    }
}
