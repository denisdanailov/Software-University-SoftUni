import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _04_ChangeTownNamesCasing {
    public static void main(String[] args) throws SQLException {

        Connection connection =LocalHost.getConnection("minions_db");

        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();

        PreparedStatement statement = connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");
        statement.setString(1, country);
        int affectedRows = statement.executeUpdate();

        if (affectedRows != 0) {
            System.out.printf("%d town names were affected.%n", affectedRows);

            PreparedStatement queryTowns = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");
            queryTowns.setString(1, country);
            ResultSet resultSet = queryTowns.executeQuery();

            List<String> countries = new ArrayList<>();

            while (resultSet.next()) {
                String countryName = resultSet.getString("name");
                countries.add(countryName);
            }

            System.out.printf("[%s]", String.join(", ", countries));
        } else {
            System.out.println("No town names were affected.");
        }

        connection.close();
    }
}
