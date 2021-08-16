package ForLoop.MoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int price = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        int sumTons = 0;

        double sumTonsBus = 0;
        double sumTonsTruck = 0;
        double sumTonsTrain = 0;

        for (int i = 0; i < n; i++) {

            int tons = Integer.parseInt(scan.nextLine());

            sumTons += tons;

            if ( tons <= 3) {
                price = 200;
                sum1 += tons * price;
                sumTonsBus += tons;
            } else if (tons >= 4 && tons <= 11) {
                price = 175;
                sum2 += tons * price;
                sumTonsTruck += tons;
            } else {
                price = 120;
                sum3 += tons * price;
                sumTonsTrain += tons;
            }
        }
        double meanPrice = (sum1 + sum2 + sum3) / sumTons;

        double bus = (sumTonsBus/sumTons)*100;
        double truck = (sumTonsTruck/sumTons)*100;
        double train = (sumTonsTrain/sumTons)*100;

        System.out.printf("%.2f%n", meanPrice);
        System.out.printf("%.2f%%%n", bus);
        System.out.printf("%.2f%%%n", truck);
        System.out.printf("%.2f%%%n", train);
    }
}
