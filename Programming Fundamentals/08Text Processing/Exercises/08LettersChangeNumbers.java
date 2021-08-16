package TextProcessing.Exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += calcLettersNumbers(input[i]);
        }

        System.out.printf("%.2f",sum);
    }

    public static double calcLettersNumbers(String text) {
        char firstLetter = text.charAt(0);
        char secondLetter = text.charAt(text.length()-1);

        text = text.replace(firstLetter, ' ');
        text = text.replace(secondLetter, ' ');
        text = text.trim();

        double number = Integer.parseInt(text);

        if (Character.isLowerCase(firstLetter)) {
            int letterPosition = firstLetter - 96;
            number *= letterPosition;
        } else {
            int letterPosition = firstLetter - 64;
            number /= letterPosition;
        }

        if (Character.isLowerCase(secondLetter)) {
            int letterPosition = secondLetter - 96;
            number += letterPosition;
        } else {
            int letterPosition = secondLetter - 64;
            number -= letterPosition;
        }

        return number;
    }
}
