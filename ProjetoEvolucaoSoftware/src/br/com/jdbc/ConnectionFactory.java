package br.com.jdbc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {
    
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
        
        if (connection == null) {
            try {
                
                //aqui colocamos os dados de acesso ao banco
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gcp", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException(e);
            } 
        }
        
        return connection;
        
    }
}
