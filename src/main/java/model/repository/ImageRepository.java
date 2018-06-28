/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.util.ArrayList;
import java.util.List;
import model.bean.Image;
import model.bean.Usuario;

/**
 *
 * @author rafae
 */
public class ImageRepository extends Repository {

    public List<Image> getAllPhotos(int firstResult, int maxResults) {
        List<Image> images = new ArrayList<>();
        try {
            beginSession();
            images = session.createQuery("FROM Image AS i JOIN FETCH i.user ORDER BY i.created_at DESC")
                    .setFirstResult(firstResult)
                    .setMaxResults(maxResults)
                    .list();
        } finally {
            closeSession();
        }
        return images;
    }

    public long newImage(Usuario user, String url) {
        try {
            beginSession();
            transaction = session.beginTransaction();
            session.createQuery("INSERT INTO images (user_id, url) VALUES (:user_id, :url)")
                    .setParameter("user_id", user.getId())
                    .setParameter("url", url)
                    .executeUpdate();
            transaction.commit();
        } finally {
            closeSession();
        }
        return 0;
    }

    public List<Image> findByUsername(String username) {
        List<Image> images = new ArrayList<>();
        try {
            beginSession();
            images = session.createQuery("FROM Image AS i JOIN FETCH i.user WHERE i.user.nome = :nome ORDER BY i.created_at DESC")
                    .setParameter("nome", username)
                    .list();
        } finally {
            closeSession();
        }
        return images;
    }
}
