package TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] userNames = scan.nextLine().split(", ");

        for (int i = 0; i < userNames.length; i++) {
            if (checkLength(userNames[i])) {
                if (checkContent(userNames[i])) {
                    System.out.println(userNames[i]);
                }
            }
        }
    }

    private static boolean checkLength(String userName) {
        return userName.length() >= 3 && userName.length() <= 16;
    }

    private static boolean checkContent(String userName) {
        boolean isValid = true;
        for (int i = 0; i < userName.length(); i++) {
            char symbol = userName.charAt(i);

            if (Character.isDigit(symbol)) {
                isValid = true;
            } else if (Character.isLetter(symbol)) {
                isValid = true;
            } else if (symbol == '-') {
                isValid = true;
            } else if (symbol == '_') {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
