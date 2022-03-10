package _03_UniversitySystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_CFX");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
