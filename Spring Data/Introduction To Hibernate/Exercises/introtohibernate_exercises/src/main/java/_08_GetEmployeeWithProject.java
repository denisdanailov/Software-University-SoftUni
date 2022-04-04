import entities.Address;
import entities.Employee;
import entities.Project;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class _08_GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter employee id:");
        Integer employeeId = Integer.parseInt(scan.nextLine());

        Employee emp = entityManager.createQuery("FROM Employee E " +
                "WHERE E.id = :emp_id", Employee.class)
                .setParameter("emp_id", employeeId)
                .getSingleResult();

        List<String> empProjects = emp.getProjects().stream().sorted((a, b) -> a.getName().compareTo(b.getName())).map(Project::getName).collect(Collectors.toList());

        System.out.printf("%s %s - %s%n",
                emp.getFirstName(),
                emp.getLastName(),
                emp.getJobTitle());

        for (int i = 0; i < empProjects.size(); i++) {
            if (i != empProjects.size() - 1) {
                System.out.printf("\t%s%n", empProjects.get(i));
            } else {
                System.out.printf("\t%s  ", empProjects.get(i));
            }
        }

        transaction.commit();
        entityManager.close();
    }
}
