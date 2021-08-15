package FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        Double priceKgVeg = Double.parseDouble(scan.nextLine());
        Double priceKgFruit = Double.parseDouble(scan.nextLine());
        int kgVeg = Integer.parseInt(scan.nextLine());
        int kgFruit = Integer.parseInt(scan.nextLine());

        //Решение
        Double revenue = (kgVeg*priceKgVeg)+(kgFruit*priceKgFruit);
        Double revenueEuro= revenue/1.94;

        //Принт
        System.out.printf("%.2f",revenueEuro);
    }
}
