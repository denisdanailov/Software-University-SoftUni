package ForLoop.Exercises;

import java.util.Scanner;

public class DivideWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(scan.nextLine());

            if (num % 2 == 0) {
                p1++;
            }
            if (num % 3 == 0) {
                p2++;
            }
            if (num % 4 == 0) {
                p3++;
            }
        }

        double p1Sum = (p1 / n) * 100;
        double p2Sum = (p2 / n) * 100;
        double p3Sum = (p3 / n) * 100;

        System.out.printf("%.2f%%%n", p1Sum);
        System.out.printf("%.2f%%%n", p2Sum);
        System.out.printf("%.2f%%%n", p3Sum);
    }
}
