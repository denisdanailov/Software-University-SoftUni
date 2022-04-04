import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        Dep. Engineering id = 1
//        Dep. Tool Design id = 2
//        Dep. Marketing id = 4
//        Dep. Information Services id = 11

        List<String> depNames = Arrays.asList("Engineering", "Tool Design", "Marketing", "Information Services");

        List<Department> depList = entityManager.createQuery("FROM Department d WHERE d.name IN (:dep_names)", Department.class)
                .setParameter("dep_names", depNames).getResultList();

        int affectedRows = entityManager.createQuery("UPDATE Employee E " +
                "SET E.salary = E.salary * 1.12 " +
                "WHERE E.department IN (:departments_list)").setParameter("departments_list", depList).executeUpdate();

        List<Employee> empList = entityManager.createQuery("FROM Employee E WHERE E.department IN (:department_list)", Employee.class)
                .setParameter("department_list", depList)
                .getResultList();

        for (Employee employee : empList) {
            System.out.printf("%s %s ($%s)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary().setScale(2, RoundingMode.HALF_UP).toString());
        }

        transaction.commit();
        entityManager.close();
    }
}
