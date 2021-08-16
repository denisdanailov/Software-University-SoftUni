package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int sumChar = 0;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int character = input.charAt(0);
            sumChar += character;
        }
        System.out.println("The sum equals: "+sumChar);
    }
}
