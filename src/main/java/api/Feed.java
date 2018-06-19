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
import model.service.ImagemService;
import org.javalite.activejdbc.LazyList;

@Path("/feed")
public class Feed {
    @GET
    @Path("/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public LazyList getMsg(@PathParam("page") int page) {
        database.Database.Open();
        return ImagemService.getAllPhotos(page);
    }

}
