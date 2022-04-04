import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _03_AddMinion {
    public static void main(String[] args) throws SQLException {

        Connection connection = LocalHost.getConnection("minions_db");

        Scanner scan = new Scanner(System.in);
        String inputLine1 = scan.nextLine();
        String minionName = inputLine1.split("\\s+")[1];
        int minionAge = Integer.parseInt(inputLine1.split("\\s+")[2]);
        String minionTown = inputLine1.split("\\s+")[3];

        String inputLine2 = scan.nextLine();
        String villainName = inputLine2.split("\\s+")[1];

        int townId = queryTownsAndInsertIfNeeded(connection, minionTown);
        int villainId = queryVillainsAndInsertIfNeeded(connection, villainName);

        if (retrieveMinionId(connection, minionName) == 0) {
           PreparedStatement insertMinion = connection.prepareStatement("INSERT INTO minions(`name`, `age`, `town_id`) VALUES (?, ?, ?);");
           insertMinion.setString(1, minionName);
           insertMinion.setInt(2, minionAge);
           insertMinion.setInt(3, townId);
           insertMinion.executeUpdate();
        }

        int minionId = retrieveMinionId(connection, minionName);

        PreparedStatement insertIntoMV = connection.prepareStatement("INSERT INTO minions_villains(`minion_id`, `villain_id`) VALUES (?, ?);");
        insertIntoMV.setInt(1, minionId);
        insertIntoMV.setInt(2, villainId);
        insertIntoMV.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

        connection.close();
    }

    private static int retrieveMinionId(Connection connection, String minionName) throws SQLException {
        PreparedStatement queryMinions = connection.prepareStatement("SELECT id FROM minions WHERE name = ?;");
        queryMinions.setString(1, minionName);
        ResultSet resultSet = queryMinions.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        return 0;
    }

    private static int queryVillainsAndInsertIfNeeded(Connection connection, String villainName) throws SQLException {
        PreparedStatement queryVillains = connection.prepareStatement("SELECT id FROM villains WHERE name = ?");
        queryVillains.setString(1, villainName);
        ResultSet resultSet = queryVillains.executeQuery();

        int villainId = 0;
        if (!resultSet.next()) {
            PreparedStatement insertIntoVillains = connection.prepareStatement("INSERT INTO villains(`name`, `evilness_factor`) VALUES (?, 'evil');");
            insertIntoVillains.setString(1, villainName);
            insertIntoVillains.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", villainName);

            ResultSet resultSet2 =  queryVillains.executeQuery();
            resultSet2.next();
            villainId = resultSet2.getInt("id");
        } else {
            villainId = resultSet.getInt("id");
        }
        return villainId;
    }

    private static int queryTownsAndInsertIfNeeded(Connection connection, String minionTown) throws SQLException {
        PreparedStatement queryTowns = connection.prepareStatement("SELECT id FROM towns WHERE name = ?;");
        queryTowns.setString(1, minionTown);
        ResultSet queryTownSet = queryTowns.executeQuery();

        int townId = 0;
        if (!queryTownSet.next()) {
            PreparedStatement insertTown = connection.prepareStatement("INSERT INTO towns(`name`) VALUES (?);");
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            System.out.printf("Town %s was added to the database.%n", minionTown);

            ResultSet newQueryTownSet = queryTowns.executeQuery();
            newQueryTownSet.next();
            townId = newQueryTownSet.getInt("id");
        } else {
            townId = queryTownSet.getInt("id");
        }
        return townId;
    }
}
