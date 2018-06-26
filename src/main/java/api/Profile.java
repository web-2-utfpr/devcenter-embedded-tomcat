/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import exception.ExceptionUtil;
import exception.UserNotFoundException;
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
import javax.ws.rs.core.Response;
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
    public Response getProfile(@PathParam("username") String username) {

        try {
            return Response.ok().entity(userRepository.findByUsername(username)).build();
        } catch (UserNotFoundException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }

    @GET
    @Path("/images/{username}")
    public Response getPhotos(@PathParam("username") String username) {
        try {
            return Response.ok().entity(imageRepository.findByUser(userRepository.findByUsername(username))).build();
        } catch (UserNotFoundException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }

    @POST
    @Path("/images/")
    @Consumes("application/x-www-form-urlencoded")
    public Response postPhoto(@Context HttpServletRequest req, @FormParam("url") String url) {
        try {
            return Response.ok().entity(imageRepository.newImage((Usuario) userRepository.findById((Long) req.getAttribute("loggedUser")), url)).build();
        } catch (UserNotFoundException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }

    @GET
    @Path("/images/")
    public Response getPhotos(@Context HttpServletRequest req) {
        try {
            return Response.ok().entity(imageRepository.findByUser(userRepository.findById((Long) req.getAttribute("loggedUser")))).build();
        } catch (UserNotFoundException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }

    @GET
    @Path("/me")
    public Response getProfile(@Context HttpServletRequest req) {
        try {
            return Response.ok().entity(userRepository.findById((Long) req.getAttribute("loggedUser"))).build();
        } catch (UserNotFoundException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }

    @GET
    @Path("/find/{username}")
    public Response search(@PathParam("username") String username) {
        return Response.ok().entity(userRepository.search(username)).build();
    }
}
