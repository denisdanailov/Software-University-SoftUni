package PreExamPreparation;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int p = Integer.parseInt(scan.nextLine());

        double priceN = 250 * n;
        double priceM = m * (priceN * 0.35);
        double priceP = p * (priceN * 0.10);

        double totalPrice = priceN + priceM + priceP;

        if (n > m) {
            totalPrice -= totalPrice * 0.15;
        }

        if (budget >= totalPrice) {
            System.out.printf("You have %.2f leva left!", Math.abs(budget - totalPrice));
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", Math.abs(budget - totalPrice));
        }

    }
}
