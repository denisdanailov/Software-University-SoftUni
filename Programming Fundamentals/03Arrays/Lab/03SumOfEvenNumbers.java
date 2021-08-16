package Arrays.Labs;

import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] allNumbers = input.split(" ");

        int[] numbers = new int[allNumbers.length];

        int sumEven = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(allNumbers[i]);
            if (numbers[i] % 2 == 0) {
                sumEven += numbers[i];
            }
        }
        System.out.println(sumEven);
    }
}

