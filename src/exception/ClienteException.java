/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author vagner
 */
public class ClienteException extends AbstractException{
    
    public ClienteException(String nameClass, String message, String line) {
        super(nameClass, message, line);
    }    
}
