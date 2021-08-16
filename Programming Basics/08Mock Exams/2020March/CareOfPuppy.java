package MockExamsPB.March2020;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int kgFood = Integer.parseInt(scan.nextLine());

        kgFood *= 1000;

        String input = scan.nextLine();
        double portion = 0;
        double sumPortion = 0;

        while (!input.equals("Adopted")) {
            portion = Double.parseDouble(input);
            sumPortion += portion;
            input = scan.nextLine();
        }

        if (sumPortion > kgFood) {
            System.out.printf("Food is not enough. You need %.0f grams more.", Math.abs(sumPortion - kgFood));
        } else {
            System.out.printf("Food is enough! Leftovers: %.0f grams.", Math.abs(sumPortion - kgFood));
        }
    }
}
