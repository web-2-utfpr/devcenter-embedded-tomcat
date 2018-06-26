/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import util.Data;
import exception.UserNotFoundException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import model.bean.Image;
import model.bean.Usuario;
import model.repository.ImageRepository;
import model.repository.UserRepository;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
public class Profile {

    private static UserRepository userRepository;
    private static ImageRepository imageRepository;

    static {
        userRepository = new UserRepository();
        imageRepository = new ImageRepository();
    }

    @GET
    @Path("/{username}")
    public Usuario getProfile(@PathParam("username") String username) throws UserNotFoundException {
        return userRepository.findByUsername(username);
    }

    @GET
    @Path("/images/{username}")
    public List<Image> getPhotos(@PathParam("username") String username) throws UserNotFoundException {
        return imageRepository.findByUsername(username);
    }

    @POST
    @Path("/images/")
    @Consumes("application/x-www-form-urlencoded")
    public Object postPhoto(@Context HttpServletRequest req, @FormParam("url") String url) throws UserNotFoundException {
        return new Data(imageRepository.newImage((Usuario) userRepository.findById((Long) req.getAttribute("loggedUser")), url));
    }

    @GET
    @Path("/me")
    public Usuario getProfile(@Context HttpServletRequest req) throws UserNotFoundException {
        return userRepository.findById((Long) req.getAttribute("loggedUser"));
    }

    @GET
    @Path("/find/{username}")
    public List<Usuario> search(@PathParam("username") String username) {
        return userRepository.search(username);
    }

}
