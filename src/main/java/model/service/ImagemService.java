package model.service;

import java.io.IOException;
import javax.servlet.http.Part;
import model.entity.Image;
import org.javalite.activejdbc.LazyList;
import util.FileHelper;
import util.imgur.Uploader;

public class ImagemService {
    
    public static LazyList getAllPhotos() {
        return Image.findAll().orderBy("create_time desc");
    }

    public static void newImage(long id, Part img) throws IOException {
        Image imagem = new Image();
        imagem.setLong("id_usuario", id);
        imagem.setString("url", Uploader.upload(FileHelper.SaveImage(img)));
        imagem.saveIt();
    }

}
