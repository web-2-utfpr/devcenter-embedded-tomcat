/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import exception.InvalidPasswordException;
import exception.UserNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.service.UsuarioService;

/**
 *
 * @author rafae
 */
public class Mutation implements GraphQLMutationResolver {
    public String login (String email, String password) {
        return email;
    }
}
