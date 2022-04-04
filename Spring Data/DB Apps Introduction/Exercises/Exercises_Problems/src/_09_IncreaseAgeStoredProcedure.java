import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _09_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Connection connection = LocalHost.getConnection("minions_db");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter minion id:");
        int minionId = Integer.parseInt(scan.nextLine());

        CallableStatement call = connection.prepareCall("CALL usp_get_older(?);");
        call.setInt(1, minionId);
        call.executeUpdate();

        PreparedStatement selectMinion = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?;");
        selectMinion.setInt(1, minionId);
        ResultSet resultSet = selectMinion.executeQuery();

        if (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        } else {
            System.out.println("No such minion exists!");
        }

        connection.close();
    }
}
