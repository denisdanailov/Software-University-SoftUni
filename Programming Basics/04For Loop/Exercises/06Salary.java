package ForLoop.Exercises;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());

        int penalty = 0;

        for (int i = 0; i < n; i++) {

            String website = scan.nextLine();

            switch (website) {
                case "Facebook":
                    penalty += 150;

                    break;
                case "Instagram":
                    penalty += 100;

                    break;
                case "Reddit":
                    penalty += 50;

                    break;
            }
        }
        salary -= penalty;

        if (salary <= 0) {
            System.out.println("You have lost your salary.");
        } else {
            System.out.printf("%d", salary);
        }
    }
}
