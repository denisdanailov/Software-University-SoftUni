import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _06_RemoveVillain {
    public static void main(String[] args) throws SQLException {

        Connection connection = LocalHost.getConnection("minions_db");

        Scanner scan = new Scanner(System.in);
        int villainId = Integer.parseInt(scan.nextLine());

        connection.setAutoCommit(false);

        try {
            PreparedStatement releaseMinions = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?;");
            releaseMinions.setInt(1, villainId);
            int affectedRows = releaseMinions.executeUpdate();

            PreparedStatement queryVillain = connection.prepareStatement("SELECT name FROM villains WHERE id = ?;");
            queryVillain.setInt(1, villainId);
            ResultSet resultSet = queryVillain.executeQuery();

            if (resultSet.next()) {
                String villainName = resultSet.getString("name");

                PreparedStatement deleteVillain = connection.prepareStatement("DELETE FROM villains WHERE id = ?;");
                deleteVillain.setInt(1, villainId);
                deleteVillain.executeUpdate();

                System.out.printf("%s was deleted%n%d minions released", villainName, affectedRows);
            } else {
                System.out.println("No such villain was found");
            }

            connection.commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
            connection.rollback();
        }

        connection.close();
    }
}
