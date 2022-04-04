
import entities.Town;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class _02_ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("FROM Town", Town.class);

        List<Town> townsList = query.getResultList();

        List<Town> attachedTowns = new ArrayList<>();

        for (Town town : townsList) {
            String townName = town.getName();

            if (townName.length() > 5) {
                entityManager.detach(town);
            } else {
                town.setName(townName.toUpperCase());
                attachedTowns.add(town);
            }
        }

        for (Town town : attachedTowns) {
            entityManager.persist(town);
        }

        transaction.commit();
        entityManager.close();
    }
}
