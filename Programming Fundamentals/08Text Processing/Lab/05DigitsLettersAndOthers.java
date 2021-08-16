package TextProcessing.Lab;

import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder specialChar = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            Character symbol = input.charAt(i);

            if (Character.isDigit(symbol)) {
                digits.append(symbol);
            } else if (Character.isLetter(symbol)) {
                letters.append(symbol);
            } else {
                specialChar.append(symbol);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(specialChar);
    }
}
