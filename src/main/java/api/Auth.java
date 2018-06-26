/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import exception.EmailAlreadyRegisteredException;
import exception.ExceptionUtil;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import exception.InvalidUsernameException;
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
import org.json.JSONObject;

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
    public Response login(@FormParam("nome") String nome, @FormParam("senha") String senha) {
        try {
            JSONObject response = new JSONObject();
            response.put("token", userRepository.login(nome, senha));
            return Response.ok().entity(response.toString()).build();
        } catch (InvalidPasswordException | UserNotFoundException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }

    @POST
    @Path("/register")
    @Consumes("application/x-www-form-urlencoded")
    public Response register(@FormParam("nome") String nome, @FormParam("senha") String senha, @FormParam("email") String email) {
        try {
            JSONObject response = new JSONObject();
            response.put("register", userRepository.registrar(nome, email, senha));
            return Response.ok().entity(response.toString()).build();
        } catch (UserAlreadyExistsException | EmailAlreadyRegisteredException | InvalidUsernameException | InvalidEmailException | InvalidPasswordException ex) {
            return ExceptionUtil.errorToResponse(ex);
        }
    }
}
