import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class _08_IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {

        Connection connection = LocalHost.getConnection("minions_db");

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter minion Ids:");
        List<String> listIds = List.of(scan.nextLine().split("\\s+"));
        String minionIds = String.join(", ", listIds);

        String sql = String.format("UPDATE minions " + "SET age = age + 1, name = LOWER(name) " + "WHERE id IN (%s);", minionIds);
        PreparedStatement updateMinions = connection.prepareStatement(sql);
        updateMinions.executeUpdate();

        PreparedStatement selectMinions = connection.prepareStatement("SELECT name, age FROM minions;");
        ResultSet resultSet = selectMinions.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        }

        connection.close();
    }
}
