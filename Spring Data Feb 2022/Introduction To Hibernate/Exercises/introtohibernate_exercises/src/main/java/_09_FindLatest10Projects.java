import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class _09_FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Project> projectsList = entityManager.createQuery("FROM Project P ORDER BY P.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        Collections.sort(projectsList,(p1, p2) -> p1.getName().compareTo(p2.getName()));

        projectsList.forEach(p -> {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            String timeZone = "UTC+3";
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

            System.out.printf("Project name: %s%n" +
                            " \tProject Description: %s%n" +
                            " \tProject Start Date:%s%n" +
                            " \tProject End Date: %s%n",
                    p.getName(),
                    p.getDescription(),
                    simpleDateFormat.format(Timestamp.valueOf(p.getStartDate())),
                    p.getEndDate() == null ? "null" : simpleDateFormat.format(Timestamp.valueOf(p.getEndDate())));
        });

        transaction.commit();
        entityManager.close();
    }
}
