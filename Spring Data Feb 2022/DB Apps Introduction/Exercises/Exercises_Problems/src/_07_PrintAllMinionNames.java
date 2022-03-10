import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class _07_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = LocalHost.getConnection("minions_db");

        PreparedStatement statement = connection.prepareStatement("SELECT name FROM minions;");
        ResultSet resultSet = statement.executeQuery();

        List<String> names = new ArrayList<>();
        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            names.add(minionName);
        }


        for (int i = 0; i < names.size(); i++) {
            if (names.size() % 2 == 0) {
                int firstIndx = i;
                int lastIndx = (names.size() - 1) - i;
                if (firstIndx < lastIndx) {
                    System.out.println(names.get(firstIndx));
                    System.out.println(names.get(lastIndx));
                } else {
                    break;
                }
            } else {
                int firstIndx = i;
                int lastIndx = (names.size() - 1) - i;
                if (firstIndx < lastIndx) {
                    System.out.println(names.get(firstIndx));
                    System.out.println(names.get(lastIndx));
                } else if (firstIndx == lastIndx){
                    System.out.println(names.get(firstIndx));
                    break;
                }
            }
        }

        connection.close();
    }
}
