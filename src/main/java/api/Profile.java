/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import exception.UserNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.service.UsuarioService;
import org.javalite.activejdbc.Model;

@Path("/profile")
public class Profile {
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Model getPhotos(@PathParam("username") String username) throws UserNotFoundException {
        database.Database.Open();
        return UsuarioService.findByUsername(username);
    }

}
