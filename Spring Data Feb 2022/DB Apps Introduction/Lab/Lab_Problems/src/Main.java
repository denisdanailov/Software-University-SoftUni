import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username (default = root):");
        String user = scanner.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println("Enter password :");
        String pass = scanner.nextLine().trim();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

//        Вариант #2 на свързване
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", "root", "0123!");

        PreparedStatement stmt = connection.prepareStatement("SELECT user_name, first_name, last_name, COUNT(ug.game_id) AS games_count \n" +
                "FROM users AS u JOIN users_games AS ug ON ug.user_id = u.id \n" +
                "WHERE user_name = ?\n" +
                "GROUP BY u.id");

        System.out.println("Enter a Diablo player's username:");
        String username = scanner.nextLine();

        stmt.setString(1, username);

        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.next()) {
            System.out.printf("No such username: " + username);
        } else {
            while (resultSet.next()) {
                System.out.printf("User: %s\n%s %s has played %d games",
                        resultSet.getString("user_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("games_count"));
            }
        }

        connection.close();
    }
}

