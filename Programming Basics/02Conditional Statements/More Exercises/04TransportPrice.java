package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class transportPrice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int n = Integer.parseInt(scan.nextLine());
        String dayOrNight = scan.nextLine();
        //Решение
        double priceTaxi = 0;
        double priceBus = 0.09 * n;
        double priceTrain = 0.06 * n;
        //Проверки
        if (dayOrNight.equals("day")) {
            priceTaxi = (n * 0.79) + 0.70;
        } else if (dayOrNight.equals("night")) {
            priceTaxi = (n * 0.90) + 0.70;
        }

        if (n < 20) {
            System.out.printf("%.2f", priceTaxi);
        } else if (n >= 20 && n < 100) {
            if (priceTaxi > priceBus) {
                System.out.printf("%.2f", priceBus);
            } else {
                System.out.printf("%.2f", priceTaxi);
            }
        } else if (n >= 100) {
            if (priceTrain < priceBus && priceTrain < priceTaxi) {
                System.out.printf("%.2f", priceTrain);
            } else if (priceBus < priceTaxi) {
                System.out.printf("%.2f", priceBus);
            } else {
                System.out.printf("%.2f", priceTaxi);
            }
        }
    }
}
