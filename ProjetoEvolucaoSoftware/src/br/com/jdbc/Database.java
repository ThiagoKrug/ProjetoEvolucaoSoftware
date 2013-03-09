/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc;

import br.com.config.ConfigurationFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Database {
    
    private String database;
    
     private Connection connection;
     private Statement stmt;

    public Database() {
        this.connection = ConnectionFactory.getConnectionWithNoDatabase();
        this.database = ConfigurationFactory.getConfiguration().get("db.database");
    }
     
     public void criarBanco() {
        String sql = "CREATE DATABASE " + this.database+" DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;";
        try {
            this.connection.setSchema("");
            stmt = this.connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void deletaBanco() {
        String sql = "DROP DATABASE " + this.database;
        try {
            this.connection.setSchema("");
            stmt = this.connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
