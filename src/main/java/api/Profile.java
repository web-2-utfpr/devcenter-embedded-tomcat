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
import model.repository.ImageRepository;
import model.repository.UserRepository;

@Path("/profile")
public class Profile {

    private static UserRepository userRepository;
    private static ImageRepository imageRepository;

    static {
        userRepository = new UserRepository();
        imageRepository = new ImageRepository();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getProfile(@PathParam("username") String username) throws UserNotFoundException {
        return userRepository.findByUsername(username);
    }
    
    @GET
    @Path("/images/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getPhotos(@PathParam("username") String username) throws UserNotFoundException {
        return imageRepository.findByUsername(username);
    }

}
