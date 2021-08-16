package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int x = Integer.parseInt(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        int wineNeededForSale = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        //Решение
        double harvest = (x * y);
        double harvestForWine = harvest * 0.40;
        double litresWine = harvestForWine / 2.5;
        //Проверки
        if (litresWine < wineNeededForSale) {
            double wineNeeded = wineNeededForSale - litresWine;
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineNeeded));
        } else if (litresWine >= wineNeededForSale) {
            double wineLeft = litresWine - wineNeededForSale;
            double wineLeftPerWorker = wineLeft / workers;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.", Math.floor(litresWine));
            System.out.println();
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wineLeft), Math.ceil(wineLeftPerWorker));
        }
    }
}
