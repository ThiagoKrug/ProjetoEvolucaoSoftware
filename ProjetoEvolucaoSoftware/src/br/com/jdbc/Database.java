/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc;

import br.com.config.ConfigurationFactory;
import java.io.DataInputStream;
import java.io.IOException;
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
    private Statement stmt;

    public Database() {
        this.database = ConfigurationFactory.getConfiguration().get("db.database");
    }

    public void criarBanco() {
        String sql = "CREATE DATABASE " + this.database + " DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;";
        try {
            stmt = ConnectionFactory.getConnectionWithNoDatabase().createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deletaBanco() {
        String sql = "DROP DATABASE " + this.database;
        try {
            stmt = ConnectionFactory.getConnectionWithNoDatabase().createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criarTabelas() {
        try {
            stmt = ConnectionFactory.getConnection().createStatement();
            DataInputStream in = new DataInputStream(this.getClass().getResourceAsStream("database.sql"));
            String sql = "";
            String line;
            while ((line = in.readLine()) != null) {

                sql += line + "\n";
            }
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //this.populate();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
