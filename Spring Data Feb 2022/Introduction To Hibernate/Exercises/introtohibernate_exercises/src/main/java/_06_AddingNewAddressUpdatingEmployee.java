import entities.Address;
import entities.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class _06_AddingNewAddressUpdatingEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Address address = new Address();
        address.setText("Vasil Levski 15");
        entityManager.persist(address);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter employee last name:");
        String lastName = scan.nextLine();

        Query dmlQuery = entityManager.createQuery("UPDATE Employee E " +
                "SET E.address = :new_address " +
                "WHERE E.lastName = :last_name");
        dmlQuery.setParameter("new_address", address);
        dmlQuery.setParameter("last_name", lastName);

        int affectedRows = dmlQuery.executeUpdate();

        transaction.commit();
        entityManager.close();
    }
}
