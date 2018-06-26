/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import exception.InvalidEmailException;

/**
 *
 * @author rafae
 */
public class EmailValidator {

    public static void isValid(String email) throws InvalidEmailException {
        if (email == null || !(email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"))) {
            throw new InvalidEmailException("Invalid Email");
        }
    }
}
