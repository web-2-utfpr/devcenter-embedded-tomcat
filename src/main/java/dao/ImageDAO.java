/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class ImageDAO extends DAO {

    public static ArrayList getPhotos(long id) {
        PrepararStatement("SELECT url, create_time FROM imagem WHERE id_usuario = ? ORDER BY create_time DESC");
        ArrayList<Image> images = new ArrayList();
        try {
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Image image = new Image();
                image.setUrl(rs.getString("url"));
                image.setCreate_time(rs.getDate("create_time"));
                images.add(image);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Close();
        }
        return images;
    }

    public static Image createImage(Image image) {
        PrepararStatement("INSERT INTO imagem (`id_usuario`, `url`, `path`) VALUES (?, ?, ?)");
        try {
            stmt.setLong(1, image.getId_usuario());
            stmt.setString(2, image.getUrl());
            stmt.setString(3, image.getPath());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Close();
        }
        return image;
    }
}
