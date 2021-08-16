package PreExamPreparation;

import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double profit = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();

        String cocktail = "";
        int numCocktails = 0;
        double priceCocktail = 0;
        double sumOrder = 0;
        double totalOrders = 0;

        while (!input.equals("Party!")) {
            cocktail = input;
            numCocktails = Integer.parseInt(scan.nextLine());

            priceCocktail = cocktail.length();
            sumOrder = priceCocktail * numCocktails;

            if (sumOrder % 2 != 0) {
                sumOrder -= sumOrder * 0.25;
            }

            totalOrders += sumOrder;

            if (totalOrders >= profit) {
                break;
            }

            input = scan.nextLine();
        }

        if (input.equals("Party!")) {
            System.out.printf("We need %.2f leva more.%n", profit - totalOrders);
        } else {
            System.out.println("Target acquired.");
        }
        System.out.printf("Club income - %.2f leva.", totalOrders);
    }
}
