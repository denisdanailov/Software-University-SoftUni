package ForLoop.MoreExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double sumPoints = 0;
        int countPoints = 0;
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        double p6 = 0;

        for (int i = 0; i < n; i++) {

            int points = Integer.parseInt(scan.nextLine());

            if (points >= 0 && points <= 9) {
                sumPoints += points * 0.20;
                p1++;
            } else if (points >= 10 && points <= 19) {
                sumPoints += points * 0.30;
                p2++;
            } else if (points >= 20 && points <= 29) {
                sumPoints += points * 0.40;
                p3++;
            } else if (points >= 30 && points <= 39) {
                sumPoints += 50;
                p4++;
            } else if (points >= 40 && points <= 50) {
                sumPoints += 100;
                p5++;
            } else {
                sumPoints /= 2;
                p6++;
            }
        }

        double Percent1 = (p1 / n) * 100;
        double Percent2 = (p2 / n) * 100;
        double Percent3 = (p3 / n) * 100;
        double Percent4 = (p4 / n) * 100;
        double Percent5 = (p5 / n) * 100;
        double Percent6 = (p6 / n) * 100;

        System.out.printf("%.2f%n", sumPoints);
        System.out.printf("From 0 to 9: %.2f%%%n", Percent1);
        System.out.printf("From 10 to 19: %.2f%%%n", Percent2);
        System.out.printf("From 20 to 29: %.2f%%%n", Percent3);
        System.out.printf("From 30 to 39: %.2f%%%n", Percent4);
        System.out.printf("From 40 to 50: %.2f%%%n", Percent5);
        System.out.printf("Invalid numbers: %.2f%%%n", Percent6);
    }
}
