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
public abstract class AbstractException  extends Exception {
    
    protected String nameClass;
    protected String message;
    protected String line;

    public AbstractException(String nameClass, String message, String line) {
        this.nameClass = nameClass;
        this.message = message;
        this.line = line;
    }
    
     @Override
    public String toString() {
        return String.format("Nome da Classe ->  %s \n Menssagem -> %s \n Linha do Erro -> %s", this.nameClass, this.message, this.line);
    }
    
}
