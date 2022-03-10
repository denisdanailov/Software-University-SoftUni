import entities.Address;
import entities.Class;
import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = new Student("Pesho", 35);
        entityManager.persist(student);

        Address address = new Address("Vasil Levski", 15);
        entityManager.persist(address);

        Class mathClass = new Class("Math", 101);
        mathClass.setCapacity(100);
        entityManager.persist(mathClass);

        transaction.commit();
        entityManager.close();
    }
}
