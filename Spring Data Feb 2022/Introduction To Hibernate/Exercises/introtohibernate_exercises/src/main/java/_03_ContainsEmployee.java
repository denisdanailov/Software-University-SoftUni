import entities.Employee;
import entities.Town;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String[] arr = scan.nextLine().split("\\s+");
        String first_name = arr[0];
        String last_name = arr[1];

        TypedQuery<Employee> selectQuery = entityManager.createQuery("FROM Employee AS E " +
                "WHERE E.firstName = :first_name AND " +
                "E.lastName = :last_name", Employee.class);

        selectQuery.setParameter("first_name", first_name);
        selectQuery.setParameter("last_name", last_name);

        Optional<Employee> optionalEmp = selectQuery.getResultStream().findFirst();

        if (optionalEmp.isPresent()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        transaction.commit();
        entityManager.close();
    }
}
