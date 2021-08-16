package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rent = Integer.parseInt(scan.nextLine());

        Double priceCake = rent * 0.2;
        Double priceDrinks = priceCake - (0.45 * priceCake);
        int Animator = rent * 1/3;

        Double finalBudget = rent + priceCake + priceDrinks + Animator;

        System.out.println(finalBudget);

    }
}
