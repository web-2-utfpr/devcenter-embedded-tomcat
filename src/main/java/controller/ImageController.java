/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImageDAO;
import entities.Image;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafae
 */
public class ImageController extends Controller {

    public ImageController(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
    }

    public ArrayList getByUserID(long id){
        return ImageDAO.getPhotos(id);
    }
    
    public void create(long id){
        Image imagem = new Image();

        imagem.setId_usuario(id);
        imagem.setUrl(request.getParameter("url"));
        imagem.setPath(request.getParameter("url"));

        ImageDAO.createImage(imagem);
    }


}
