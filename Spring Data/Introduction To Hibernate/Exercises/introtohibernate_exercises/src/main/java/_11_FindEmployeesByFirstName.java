import entities.Employee;

import javax.persistence.*;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class _11_FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name pattern:");

        StringBuilder sb = new StringBuilder();
        sb.append(scan.nextLine()).append("%");

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee E WHERE E.firstName LIKE :name_param", Employee.class);
        query.setParameter("name_param", sb.toString());

        List<Employee> employees = query.getResultList();

        for (Employee emp : employees) {
            System.out.printf("%s %s - %s - ($%s)%n",
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getJobTitle(),
                    emp.getSalary().toString());
        }

        transaction.commit();
        entityManager.close();
    }
}
