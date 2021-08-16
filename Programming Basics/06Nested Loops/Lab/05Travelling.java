package NestedLoops.Labs;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        double minBudget = 0;
        double cash = 0;
        double sum = 0;

        while (!input.equals("End")) {
            String destination = input;
            minBudget = Double.parseDouble(scan.nextLine());
            while (sum < minBudget) {
                cash = Double.parseDouble(scan.nextLine());
                sum += cash;
            }
                System.out.printf("Going to %s!%n", destination);
                sum = 0;

            input = scan.nextLine();
        }
    }
}
