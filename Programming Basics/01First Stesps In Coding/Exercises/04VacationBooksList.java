package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pages = Integer.parseInt(scan.nextLine());
        int pagePerHour = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());

        int hoursForReadingOneBook = pages / pagePerHour;
        int hoursPerDay = hoursForReadingOneBook / days;

        System.out.println(hoursPerDay);
    }
}
