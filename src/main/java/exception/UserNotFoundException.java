/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * @author lucas
 */
public class UserNotFoundException extends BaseException {

    public UserNotFoundException() {
        super(messages.getString("userNotRegistered"));
    }

}
