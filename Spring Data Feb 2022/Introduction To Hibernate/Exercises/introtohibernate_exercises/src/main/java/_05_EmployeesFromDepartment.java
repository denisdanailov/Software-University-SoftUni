import entities.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class _05_EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String department = "Research and Development";

        TypedQuery<Employee> dqlQuery = entityManager.createQuery("FROM Employee AS E " +
                "WHERE E.department.name = :department " +
                "ORDER BY E.salary, E.id", Employee.class);
        dqlQuery.setParameter("department", department);

        List<Employee> resultList = dqlQuery.getResultList();

        for (Employee employee : resultList) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary().doubleValue());
        }

        transaction.commit();
        entityManager.close();
    }
}
