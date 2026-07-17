package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static ResourceBundle reader = ResourceBundle.getBundle("dbconfig.properties");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(reader.getString("db.url"), reader.getString("db.username"), reader.getString("db.password"));
    }
}
