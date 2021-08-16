package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String projectionType = scan.nextLine();
        int row = Integer.parseInt(scan.nextLine());
        int column = Integer.parseInt(scan.nextLine());

        double priceProjection = 0;

        switch (projectionType) {
            case "Premiere":
                priceProjection = 12.00;
                break;
            case "Normal":
                priceProjection = 7.50;
                break;
            case "Discount":
                priceProjection = 5.00;
                break;
        }

        double revenueProjection = (row * column) * priceProjection;

        System.out.printf("%.2f leva", revenueProjection);
    }
}
