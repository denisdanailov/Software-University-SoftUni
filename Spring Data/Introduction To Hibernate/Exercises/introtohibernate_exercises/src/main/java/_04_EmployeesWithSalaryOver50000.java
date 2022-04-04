import entities.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class _04_EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<String> dqlQuery = entityManager.createQuery("SELECT E.firstName FROM Employee E WHERE E.salary > 50000", String.class);
        List<String> resultList = dqlQuery.getResultList();

        for (String firstName : resultList) {
            System.out.println(firstName);
        }

//        Alternative Approach - Logic in Business layer
//        Query select_all_from_employees = entityManager.createQuery("FROM Employee");
//        List<Employee> resultList = select_all_from_employees.getResultList();
//
//        for (Employee employee : resultList) {
//            BigDecimal salaryThreshold = BigDecimal.valueOf(50000);
//            if (employee.getSalary().compareTo(salaryThreshold) == 1) {
//                System.out.println(employee.getFirstName());
//            }
//        }

        transaction.commit();
        entityManager.close();
    }
}
