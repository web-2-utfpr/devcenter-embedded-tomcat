/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import exception.EmailAlreadyRegisteredException;
import exception.InvalidPasswordException;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.repository.UserRepository;
import util.Data;

/**
 *
 * @author rafae
 */
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public class Auth {

    private static UserRepository userRepository;

    static {
        userRepository = new UserRepository();
    }

    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    public Object login(@FormParam("nome") String nome, @FormParam("senha") String senha) {
        try {
            return new Data(userRepository.login(nome, senha));
        } catch (InvalidPasswordException | UserNotFoundException ex) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes("application/x-www-form-urlencoded")
    public Object register(@FormParam("nome") String nome, @FormParam("senha") String senha, @FormParam("email") String email) {
        try {
            return new Data(userRepository.registrar(nome, email, senha));
        } catch (EmailAlreadyRegisteredException | UserAlreadyExistsException e) {
            return Response.status(201).build();
        }
    }
}
