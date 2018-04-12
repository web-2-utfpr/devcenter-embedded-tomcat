/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImageDAO;
import entities.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import service.Uploader;

/**
 *
 * @author rafae
 */
public class ImageController extends Controller {

    private static final String SAVE_DIR = "uploadFiles";

    public ImageController(HttpServletRequest req, HttpServletResponse resp) {
        super(req, resp);
    }

    public ArrayList getByUserID(long id) {
        return ImageDAO.getPhotos(id);
    }

    public void create(long id) throws IOException, ServletException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");

        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        Part part = request.getPart("imagem");
        String fileName = extractFileName(part);
        // refines the fileName in case it is an absolute path
        fileName = new File(fileName).getName();
        part.write(savePath + File.separator + fileName);
        
        Image imagem = new Image();
        imagem.setId_usuario(id);
        imagem.setUrl(Uploader.upload(new File(savePath + File.separator + fileName)));
        imagem.setPath(imagem.getUrl());
        ImageDAO.createImage(imagem);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
