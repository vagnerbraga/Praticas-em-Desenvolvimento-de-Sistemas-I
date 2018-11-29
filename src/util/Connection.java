/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import exception.ConnectionException;
import java.sql.DriverManager;

/**
 *
 * @author vagner
 */
public class Connection {
    
    //TODO tentar fazer conexao com banco MySQL
    String driver = "jdbc:mysql:";
    String bancoDados = "//localhost:3306/posto_combustivel";
    String user = "root";
    String pass = "root";
        
    public java.sql.Connection getConnection() throws Exception {
        java.sql.Connection con = null;
       
        try {
            //Acessar a classe Driver mysql
            Class.forName("com.mysql.jdbc.Driver");
            //estabelecimento da conexao atraves da invocacao do metodo getConnection
            con = (java.sql.Connection) DriverManager.getConnection(driver + bancoDados, user, pass);
            
            return con;
                    
        } catch (Exception e) {
            throw new ConnectionException(this.getClass().getSimpleName(), e.getMessage(), e.getCause().getCause().toString());
        }
    }
}
