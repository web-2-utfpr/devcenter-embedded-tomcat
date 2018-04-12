/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.ImageDAO;
import service.ImageService;
import service.imgur.Uploader;

/**
 *
 * @author rafae
 */
public class ImageController extends Controller {

    public ImageController(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
    }

    public ArrayList getByUserID(long id) {
        return ImageDAO.getPhotos(id);
    }

    public void create(long id) throws IOException, ServletException {
        Image imagem = new Image();
        imagem.setId_usuario(id);
        imagem.setUrl(Uploader.upload(ImageService.SaveImage(request)));
        ImageDAO.createImage(imagem);
    }

}
