package NestedLoops.MoreExercises;

import java.util.Scanner;

public class HappyCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());

        double tax = 0;
        double totalSum = 0;

        for (int i = 1; i <= days; i++) {
            double sum = 0;
            for (int j = 1; j <= hours ; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    tax = 2.50;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    tax = 1.25;
                } else {
                    tax = 1;
                }
                sum += tax;
                totalSum += tax;
            }
            System.out.printf("Day: %d - %.2f leva%n", i, sum);
        }
        System.out.printf("Total: %.2f leva%n", totalSum);
    }
}
