/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;
import model.bean.Image;

/**
 *
 * @author rafae
 */
public class ImageRepository extends Repository {

    public List<Image> getAllPhotos(int firstResult, int maxResults) {
        List<Image> images = new ArrayList<>();
        try {
            beginSession();
            images = session.createQuery("FROM Image AS i JOIN FETCH i.user ORDER BY i.created_at DESC", Image.class)
                    .setFirstResult(firstResult)
                    .setMaxResults(maxResults)
                    .list();
        } finally {
            closeSession();
        }
        return images;
    }

    public void newImage(long id, Part img) throws IOException {

    }

    public Object findByUsername(String username) {
        List<Image> images = new ArrayList<>();
        try {
            beginSession();
            images = session.createQuery("FROM Image AS i JOIN FETCH i.user WHERE i.user.nome = :nome ORDER BY i.created_at DESC", Image.class)
                    .setParameter("nome", username)
                    .list();
        } finally {
            closeSession();
        }
        return images;
    }
}
