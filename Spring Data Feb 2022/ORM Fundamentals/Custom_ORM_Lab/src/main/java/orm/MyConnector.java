package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private static Connection connection;
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/";

    public static void createConnection(String user, String password, String dbName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager.getConnection(JDBC_URL + dbName, properties);
    }

    public static Connection getConnection() {
     return connection;
    }
}
