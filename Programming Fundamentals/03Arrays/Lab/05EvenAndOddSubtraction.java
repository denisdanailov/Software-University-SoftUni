package Arrays.Labs;

import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] splitNum = input.split(" ");

        int[] numbers = new int[splitNum.length];

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(splitNum[i]);
            if (numbers[i] % 2 == 0) {
                sumEven += numbers[i];
            } else {
                sumOdd += numbers[i];
            }
        }
        int differance = sumEven - sumOdd;
        System.out.println(differance);
    }
}
