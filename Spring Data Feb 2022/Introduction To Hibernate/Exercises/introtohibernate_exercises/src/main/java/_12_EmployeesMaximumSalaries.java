import entities.Department;
import entities.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class _12_EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        Alternative Solution: Object[]
//        List<Object[]> resultList = entityManager.createQuery("SELECT d.name, MAX(e.salary) FROM Employee AS e JOIN e.department AS d " +
//                "GROUP BY d.id HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class).getResultList();
//
//        for (Object[] object:
//             resultList) {
//            String depName = (String)object[0];
//            BigDecimal maxSalary = (BigDecimal)object[1];
//            System.out.printf("%s %s%n", depName, maxSalary.toString());
//        }

        List<String> resultList = entityManager.createQuery("SELECT CONCAT(d.name, ', ', MAX(e.salary)) FROM Employee AS e JOIN e.department AS d " +
                "GROUP BY d.id HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", String.class).getResultList();

        for (String params: resultList) {
            String depName = params.split(",\\s+")[0];
            BigDecimal maxSalary = BigDecimal.valueOf(Double.parseDouble(params.split(",\\s+")[1]));
            System.out.printf("%s %s%n", depName, maxSalary.toString());
        }

        transaction.commit();
        entityManager.close();
    }
}
