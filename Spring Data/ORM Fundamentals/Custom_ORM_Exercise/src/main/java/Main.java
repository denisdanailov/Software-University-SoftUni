import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException {

        MyConnector.createConnection("root", "0123", "custom_orm");
        Connection connection = MyConnector.getConnection();

        User user1 = new User("apolo11", 35, LocalDate.now());

        EntityManager<User> entityManager = new EntityManager<>(connection);
//        entityManager.persist(user1);
        user1.setId(1);
        entityManager.persist(user1);
    }
}
