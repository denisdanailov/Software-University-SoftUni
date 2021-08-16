package Methods.Exercises;

import java.util.Scanner;

public class passwordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        if (!checkRange(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!checkDigitCount(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (checkRange(password) && checkLettersAndDigits(password) && checkDigitCount(password)) {
            System.out.println("Password is valid");
        }
    }

    public static boolean checkRange(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean checkLettersAndDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isLetter = Character.isLetter(symbol);
            boolean isDigit = Character.isDigit(symbol);

            if (!isLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDigitCount(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isDigit = Character.isDigit(symbol);
            if (isDigit) {
                count++;
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
}
