/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.util.ResourceBundle;

/**
 *
 * @author lucas
 */
public class EmailAlreadyRegisteredException extends BaseException {

    public EmailAlreadyRegisteredException() {
        super(messages.getString("emailInUse"));
    }
    
}
