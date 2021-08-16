package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        double totalSum = 0;
        int count = 0;
        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                totalSum += keyboardPrice;
                count++;
                if (count %2 == 0) {
                    totalSum += displayPrice;
                }
            }
            if (i % 2 == 0) {
                totalSum += headsetPrice;
            }
            if (i % 3 == 0) {
                totalSum += mousePrice;
            }
        }
        System.out.printf("Rage expenses: %.02f lv.%n", totalSum);
    }
}
