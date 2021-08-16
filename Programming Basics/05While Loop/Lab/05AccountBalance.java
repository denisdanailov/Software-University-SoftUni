package WhileLoop.Labs;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sum = 0;

        while (!input.equals("NoMoreMoney")) {

            double amount = Double.parseDouble(input);

            if (amount > 0) {
                System.out.printf("Increase: %.2f%n", amount);
            } else {
                System.out.println("Invalid operation!");
                break;
            }

            sum += amount;

            input = scan.nextLine();
        }
        System.out.printf("Total: %.2f", sum);
    }
}
