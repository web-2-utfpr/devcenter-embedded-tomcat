/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
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
        String searchQuery = "SELECT url, create_time FROM imagem WHERE id_usuario = ?";
        PreparedStatement stmt = null;
        Map<String, Date> urls = new HashMap();
        try {
            currentCon = Conexao.GetConnection();
            stmt = currentCon.prepareStatement(searchQuery);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
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
}
