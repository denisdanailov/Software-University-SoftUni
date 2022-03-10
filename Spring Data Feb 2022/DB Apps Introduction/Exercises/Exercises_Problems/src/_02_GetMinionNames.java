import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _02_GetMinionNames {

    public static void main(String[] args) throws SQLException {

        Connection connect = LocalHost.getConnection("minions_db");

        PreparedStatement statementMinions = connect.prepareStatement("SELECT DISTINCT m.name AS minion_name, m.age\n" +
                "FROM minions AS m JOIN minions_villains AS mv ON m.id = mv.minion_id\n" +
                "WHERE mv.villain_id = ?;");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(scan.nextLine());

        statementMinions.setInt(1,villainId);
        ResultSet resultSetMinions = statementMinions.executeQuery();

        PreparedStatement statementVillains = connect.prepareStatement("SELECT name FROM villains WHERE id = ?");
        statementVillains.setInt(1, villainId);
        ResultSet resultSetVillains = statementVillains.executeQuery();

        if (resultSetVillains.next()) {
            System.out.println("Villain: " + resultSetVillains.getString("name"));
        } else {
            System.out.println("No villain with ID " + villainId + " exists in the database.");
        }

        int count = 0;
        while (resultSetMinions.next()) {
            System.out.printf("%d. %s %d\n",
                    ++count,
                    resultSetMinions.getString("minion_name"),
                    resultSetMinions.getInt("age"));
        }

        connect.close();
    }
}
