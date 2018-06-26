/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.repository.ImageRepository;

@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
public class Feed {
    
    private static ImageRepository imageRepository;
    private static int PAGESIZE = 3;
    
    static {
        imageRepository = new ImageRepository();
    }
    
    @GET
    @Path("/{page}")
    public Response getMsg(@PathParam("page") int page) {
        return Response.ok().entity(imageRepository.getAllPhotos(page * PAGESIZE, PAGESIZE)).build();
    }

}
