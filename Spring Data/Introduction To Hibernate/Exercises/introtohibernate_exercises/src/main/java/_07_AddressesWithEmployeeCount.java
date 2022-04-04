import entities.Address;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class _07_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Address> dqlQuery = entityManager.createQuery("FROM Address A ORDER BY A.employees.size DESC", Address.class)
                .setMaxResults(10);
        List<Address> resultList = dqlQuery.getResultList();

        for (Address address : resultList) {
            System.out.printf("%s, %s - %d employees",
                    address.getText(),
                    address.getTown() == null ? "" : address.getTown().getName(),
                    address.getEmployees().size());
        }

        transaction.commit();
        entityManager.close();
    }
}
