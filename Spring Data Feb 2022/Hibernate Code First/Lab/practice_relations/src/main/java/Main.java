import many_to_many.BasicIngredient;
import many_to_many.ProductionBatch;
import many_to_many.BasicLabel;
import many_to_many.BasicShampoo;
import self_referencing.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Relations_Practice");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

//        BasicLabel label = new BasicLabel("blue");
//        entityManager.persist(label);
//
//        ProductionBatch batch = new ProductionBatch(LocalDate.now());
//        entityManager.persist(batch);
//
//        BasicIngredient ingredient = new BasicIngredient("Fermuldehait", 70.01);
//        entityManager.persist(ingredient);
//
//        BasicIngredient ingredient2 = new BasicIngredient("h2O", 100.50);
//        entityManager.persist(ingredient2);
//
//        BasicShampoo shampoo = new BasicShampoo("WashNGo",label, batch);
//        shampoo.addIngredient(ingredient);
//        shampoo.addIngredient(ingredient2);
//
//        entityManager.persist(shampoo);

        Employee emp = new Employee("Pesho", 35000.00);

        Employee manager = new Employee("Spas", 45000.00);
        entityManager.persist(manager);

        emp.setManager(manager);

        entityManager.persist(emp);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
