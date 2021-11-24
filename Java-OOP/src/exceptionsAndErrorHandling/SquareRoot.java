package exceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            double number = Double.parseDouble(scan.nextLine());
            System.out.println(calculateSquareRoot(number));
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Invalid Number");
        } finally {
            System.out.println("Good bye");
        }
    }

    private static double calculateSquareRoot(double number) {
        return Math.sqrt(number);
    }
}
