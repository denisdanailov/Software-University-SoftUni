package WhileLoop.Labs;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        String output = "";
        int year = 1;

        double sum = 0;
        int expelled = 0;

        while (year <= 12) {

            double grade = Double.parseDouble(scan.nextLine());

            if (grade >= 4.00) {
                year++;
                sum += grade;
            } else {
                expelled++;
            }

            if (expelled > 1) {
                break;
            }
        }
        if (year == 13) {
            double average = sum / (year - 1);
            output = String.format("%s graduated. Average grade: %.2f", name, average);
        } else if (expelled > 1) {
            output = String.format("%s has been excluded at %d grade", name, year);
        }

        System.out.println(output);
    }
}
