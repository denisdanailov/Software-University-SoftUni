package Methods.Exercises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            int number = Integer.parseInt(input);

            isPalindromeInteger(number);
            input = scan.nextLine();
        }
    }

    public static void isPalindromeInteger(int number) {
        int originalValue = number;
        int sum = 0, digit = 0;

        while (number != 0) {
            digit = number % 10;
            sum = (sum * 10) + digit;
            number /= 10;
        }

        if (originalValue == sum) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
