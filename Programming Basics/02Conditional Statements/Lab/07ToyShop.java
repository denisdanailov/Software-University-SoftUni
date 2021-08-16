package ConditionalStatements.Labs;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        double priceVacation = Double.parseDouble(scan.nextLine());
        int puzzles = Integer.parseInt(scan.nextLine());
        int dolls = Integer.parseInt(scan.nextLine());
        int teddyBears = Integer.parseInt(scan.nextLine());
        int minions = Integer.parseInt(scan.nextLine());
        int trucks = Integer.parseInt(scan.nextLine());
        //Решение
        double pricePuzzles = 2.60;
        int priceDolls = 3;
        double priceTeddyBears = 4.10;
        double priceMinions = 8.20;
        int priceTrucks = 2;

        double salesRevenue =(puzzles*pricePuzzles)+(dolls*priceDolls)+(teddyBears*priceTeddyBears)+(minions*priceMinions)+(trucks*priceTrucks);
        double discount = 0.25;

        if ((puzzles+dolls+teddyBears+minions+trucks) >= 50) {
            salesRevenue = salesRevenue - (salesRevenue*discount);
        }
        double rent = salesRevenue*0.10;
        salesRevenue = salesRevenue - rent;

            if (salesRevenue >= priceVacation) {
                double moneyLeft = salesRevenue - priceVacation;
                System.out.printf("Yes! %.2f lv left.", moneyLeft);
                System.out.println();
            } else if (salesRevenue <= priceVacation){
            double moneyNeeded = priceVacation - salesRevenue;
            System.out.printf("Not enough money! %.2f lv needed.",moneyNeeded);
            System.out.println();
        }
    }
}
