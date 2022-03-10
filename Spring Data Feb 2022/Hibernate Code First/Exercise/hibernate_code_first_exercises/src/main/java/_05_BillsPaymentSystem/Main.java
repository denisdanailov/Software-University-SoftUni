package _05_BillsPaymentSystem;

import _05_BillsPaymentSystem.entities.BillingDetail;
import _05_BillsPaymentSystem.entities.CreditCard;
import _05_BillsPaymentSystem.entities.User;
import _05_BillsPaymentSystem.enums.CardType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Month;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_CFX");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        CreditCard creditCard = new CreditCard(25, "Oleg", CardType.MASTER_CARD, Month.DECEMBER, 2025);

        entityManager.persist(creditCard);

        BillingDetail billingDetailOleg = entityManager.find(BillingDetail.class, 1);

        User user = new User("Oleg", "Kuzmanov", "o.k@abv.bg", "01234", billingDetailOleg);

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
