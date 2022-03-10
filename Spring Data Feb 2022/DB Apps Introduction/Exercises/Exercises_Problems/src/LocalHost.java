import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class LocalHost {
    private static Connection connection;
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/";

    private LocalHost() {};

    private static void createConnection(String databaseName) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "0123");

        connection = DriverManager.getConnection(JDBC_URL + databaseName, properties);
    }

    public static Connection getConnection(String databaseName) throws SQLException {
        if (connection == null) {
            createConnection(databaseName);
        }
        return connection;
    }
}
