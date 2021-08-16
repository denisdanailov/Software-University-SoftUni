package MockExamsPB.March2020;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        double foodAmount = Double.parseDouble(scan.nextLine());

        double sumEatenDogFood = 0;
        double sumEatenCatFood = 0;
        double sumEatenFood = 0;
        int count = 0;
        double biscuits = 0;
        double sumBiscuits = 0;

        for (int i = 1; i <= days; i++) {
            count++;
            int eatenDogFood = Integer.parseInt(scan.nextLine());
            int eatenCatFood = Integer.parseInt(scan.nextLine());

            sumEatenDogFood += eatenDogFood;
            sumEatenCatFood += eatenCatFood;

            if (count % 3 == 0) {
                biscuits = (eatenCatFood + eatenDogFood) * 0.10;
                sumBiscuits += biscuits;
            }
        }
        sumEatenFood = sumEatenCatFood + sumEatenDogFood;
        System.out.printf("Total eaten biscuits: %.0fgr.%n", sumBiscuits);
        double eatenFood = (((sumEatenCatFood + sumEatenDogFood) / foodAmount) * 100);
        System.out.printf("%.2f%% of the food has been eaten.%n", eatenFood);
        double percentDog = (sumEatenDogFood / sumEatenFood) * 100;
        System.out.printf("%.2f%% eaten from the dog.%n", percentDog);
        double percentCat = (sumEatenCatFood / sumEatenFood) * 100;
        System.out.printf("%.2f%% eaten from the cat.%n", percentCat);
    }
}
