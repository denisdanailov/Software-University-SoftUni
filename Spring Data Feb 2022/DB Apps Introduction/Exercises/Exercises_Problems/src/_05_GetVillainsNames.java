import java.sql.*;
import java.util.Properties;

public class _05_GetVillainsNames {

    public static void main(String[] args) throws SQLException {

        Connection connect = LocalHost.getConnection("minions_db");

        PreparedStatement statement = connect.prepareStatement("SELECT v.name, COUNT(Distinct mv.minion_id) as minion_count\n" +
                "FROM villains as v LEFT JOIN minions_villains as mv ON mv.villain_id = v.id\n" +
                "GROUP BY v.id\n" +
                "HAVING minion_count > 15\n" +
                "ORDER BY minion_count DESC");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("name");
            int minionCount = resultSet.getInt("minion_count");
            System.out.println(villainName + " " + minionCount);
        }

        connect.close();
    }
}
