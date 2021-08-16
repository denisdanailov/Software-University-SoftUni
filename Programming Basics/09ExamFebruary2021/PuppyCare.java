package ExamFebruary2021;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dogfoodKg = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        double dogFoodGrams = dogfoodKg * 1000;
        double gramsPerServing = 0;
        double totalFood = 0;

        while (!input.equals("Adopted")) {
            gramsPerServing = Double.parseDouble(input);
            totalFood += gramsPerServing;

            input = scan.nextLine();
        }

        if (totalFood <= dogFoodGrams) {
            System.out.printf("Food is enough! Leftovers: %.0f grams.", Math.abs(totalFood - dogFoodGrams));
        } else {
            System.out.printf("Food is not enough. You need %.0f grams more.", Math.abs(totalFood - dogFoodGrams));
        }
    }
}
