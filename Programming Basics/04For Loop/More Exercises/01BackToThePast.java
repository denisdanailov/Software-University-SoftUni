package ForLoop.MoreExercises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double inheritance = Double.parseDouble(scan.nextLine());
        int year = Integer.parseInt(scan.nextLine());

        double expenses = 0;
        int age = 17;

        for (int i = 1800; i <= year; i++) {
            if (i % 2 == 0) {
                age++;
                expenses += 12000;
            } else {
                age++;
                expenses += 12000 + (50 * age);
            }
        }

        if (expenses > inheritance) {
            System.out.printf("He will need %.2f dollars to survive.", (expenses - inheritance));
        } else {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", (inheritance - expenses));
        }
    }
}
