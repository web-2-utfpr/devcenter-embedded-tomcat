package model.dao;

import model.entities.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageDAO extends DAO {

    public static ArrayList getAllPhotos() {
        PrepararStatement("SELECT url, create_time FROM imagem ORDER BY create_time DESC");
        ArrayList<Image> images = new ArrayList();
        try {
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
        PrepararStatement("INSERT INTO imagem (`id_usuario`, `url`) VALUES (?, ?)");
        try {
            stmt.setLong(1, image.getId_usuario());
            stmt.setString(2, image.getUrl());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Close();
        }
        return image;
    }

    public static ArrayList getPhotosByUserOrImageUrl(String q) {
        PrepararStatement("SELECT url, create_time FROM imagem "
                + "LEFT JOIN usuario ON usuario.id = imagem.id_usuario "
                + "WHERE usuario.nome LIKE ? OR imagem.url LIKE ? "
                + "ORDER BY create_time DESC");
        ArrayList<Image> images = new ArrayList();
        try {
            stmt.setString(1, "%" + q + "%");
            stmt.setString(2, "%" + q + "%");
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
}
