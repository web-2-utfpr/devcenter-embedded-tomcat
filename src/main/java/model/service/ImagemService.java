package model.service;

import java.io.IOException;
import javax.servlet.http.Part;
import model.Imagem;
import model.Usuario;
import org.javalite.activejdbc.LazyList;
import util.FileHelper;
import util.imgur.Uploader;

public class ImagemService {
    
    public static LazyList getAllPhotos() {
        return Imagem.findAll().orderBy("create_time DESC");
    }

    public static LazyList getByUserID(long id) {
        return Imagem.where("id_usuario = ?", id).orderBy("create_time DESC");
    }

    public static void create(long id, Part img) throws IOException {
        Imagem imagem = new Imagem();
        imagem.setLong("Id_usuario", id);
        imagem.setString("Url", Uploader.upload(FileHelper.SaveImage(img)));
        imagem.save();
    }

    public static LazyList getPhotosByUsername(String username) {
        return getByUserID(Usuario.findFirst("nome = ?", username).getLongId());
    }
    
}
