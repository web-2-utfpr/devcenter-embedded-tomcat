/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import exception.InvalidPasswordException;

/**
 * @author rafae
 */
public class PasswordValidator {
    public static void isValid(String password) throws InvalidPasswordException {
        if (password == null || password.length() < 8) {
            throw new InvalidPasswordException();
        }
    }
}
