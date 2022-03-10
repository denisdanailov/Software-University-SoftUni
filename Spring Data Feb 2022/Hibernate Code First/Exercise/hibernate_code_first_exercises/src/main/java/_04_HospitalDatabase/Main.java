package _04_HospitalDatabase;

import _04_HospitalDatabase.entities.Diagnose;
import _04_HospitalDatabase.entities.Medicament;
import _04_HospitalDatabase.entities.Patient;
import _04_HospitalDatabase.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_CFX");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter patient's first name:");
        String firstName = scan.nextLine();

        if (checkValidInput(firstName)) return;

        System.out.println("Please enter patient's last name:");
        String lastName = scan.nextLine();

        if (checkValidInput(lastName)) return;

        System.out.println("Please enter patient's address:");
        String address = scan.nextLine();

        if (checkValidInput(address)) return;

        System.out.println("Please enter patient's email:");
        String email = scan.nextLine();

        if (checkValidInput(email)) return;

        System.out.println("Please enter patient's date of birth: (Correct format YYYY-MM-DD)");
        String dateString = scan.nextLine();

        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(dateString);
        } catch (NullPointerException | DateTimeParseException exception) {
            System.out.println("Incorrect date format! Null is also not a valid date format.");
            return;
        }

        System.out.println("Does the patient have medical insurance? (Valid answer: Yes/No)");
        String yesNOInput = scan.nextLine();

        Boolean isEnsured = null;

        if (yesNOInput.equals("Yes")) {
            isEnsured = true;
        } else if (yesNOInput.equals("No")) {
            isEnsured = false;
        } else {
            System.out.println("Enter valid Yes or No answer!");
            return;
        }

        System.out.println("Please enter visitation purpose:");
        String visitComment = scan.nextLine();

        if (checkValidInput(visitComment)) return;

        System.out.println("Please enter patient's diagnose:");
        String diagnoseName = scan.nextLine();

        if (checkValidInput(diagnoseName)) return;

        System.out.println("Please enter comment for the diagnose:");
        String comment = scan.nextLine();

        if (checkValidInput(comment)) return;

        System.out.println("Please enter the name of the prescribed medicament:");
        String medicamentName = scan.nextLine();

        if (checkValidInput(medicamentName)) return;

        System.out.println("Thank you doctor, you have saved the day once again ;)");

        Medicament med = new Medicament(medicamentName);
        entityManager.persist(med);

        Diagnose diagnose = new Diagnose(diagnoseName, comment);
        diagnose.addMedicament(med);
        entityManager.persist(diagnose);

        Patient patient = new Patient(firstName, lastName, address, email, dateOfBirth, null, isEnsured, diagnose);
        entityManager.persist(patient);

        Visitation visit = new Visitation(LocalDate.now(), visitComment, patient);
        entityManager.persist(visit);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static boolean checkValidInput(String input) {
        if(input == null || input.trim().equals("")) {
            System.out.println("Input shouldn't be Null or an empty String value!");
            return true;
        }
        return false;
    }
}
