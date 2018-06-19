package model.service;

import database.Database;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;
import model.bean.ImageBean;
import model.entity.Image;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import util.FileHelper;
import util.imgur.Uploader;

public class ImagemService {

    static int PAGESIZE = 5;

    public static LazyList getAllPhotos(int page) {
        page = page > 1 ? page : 1;
        return Image.findAll().orderBy("created_at desc").offset((page - 1) * PAGESIZE).limit(PAGESIZE);
    }

    public static void newImage(long id, Part img) throws IOException {
        Image imagem = new Image();
        imagem.setLong("user_id", id);
        imagem.setString("url", Uploader.upload(FileHelper.SaveImage(img)));
        imagem.saveIt();
    }
    
    public static List<ImageBean> RESTgetAllPhotos(int page) {
        page = page > 1 ? page : 1;
        List resposta = new ArrayList();
        for (Model m : Image.findAll().orderBy("created_at desc").offset((page - 1) * PAGESIZE).limit(PAGESIZE)){
            resposta.add(new ImageBean(m.getString("url"), m.getTimestamp("created_at").toLocalDateTime().toString()));
        }
        return resposta;
    }

}
