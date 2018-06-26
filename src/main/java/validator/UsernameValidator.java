/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import exception.InvalidUsernameException;

/**
 *
 * @author rafae
 */
public class UsernameValidator {

    public static void isValid(String username) throws InvalidUsernameException {
        if (username == null || !(username.matches("^[a-zA-Z]+[0-9]*$"))) {
            throw new InvalidUsernameException("Invalid Username");
        }
    }
}
