import entities.Address;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Student student = new Student("Pesho", 35);
        student.setAllowance(365.59);
        session.save(student);

        Address address = new Address("Vasil Levski", 15);
        address.setTown("Sofia");
        session.save(address);

        session.getTransaction().commit();
        session.close();
    }
}
