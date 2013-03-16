package br.com.jdbc;

import br.com.config.ConfigurationFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ini4j.Profile.Section;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {

    private static Connection connection;
    private static Connection connectionNoDatabase;

    public static Connection getConnection() {
        if (connection == null) {
            Section config = ConfigurationFactory.getConfiguration();
            try {
                //aqui colocamos os dados de acesso ao banco
                if (config.get("db.name").equalsIgnoreCase("mysql")) {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connection = DriverManager.getConnection("jdbc:mysql://" + config.get("db.host") + ":3306/" + config.get("db.database") + "?autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8",
                            config.get("db.user"), config.get("db.password"));
                }
            } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static Connection getConnectionWithNoDatabase() {
        if (connectionNoDatabase == null) {
            Section config = ConfigurationFactory.getConfiguration();
            try {
                //aqui colocamos os dados de acesso ao banco
                if (config.get("db.name").equalsIgnoreCase("mysql")) {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    connectionNoDatabase = DriverManager.getConnection("jdbc:mysql://" + config.get("db.host") + ":3306/?autoReconnect=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8",
                            config.get("db.user"), config.get("db.password"));
                }
            } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connectionNoDatabase;
    }
}
