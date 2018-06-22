/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.bean.Image;
import model.repository.ImageRepository;

@Path("/feed")
public class Feed {
    
    private static ImageRepository imageRepository;
    private static int PAGESIZE = 5;
    
    static {
        imageRepository = new ImageRepository();
    }
    
    @GET
    @Path("/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Image> getMsg(@PathParam("page") int page) {
        return imageRepository.getAllPhotos(page * PAGESIZE, PAGESIZE);
    }

}
