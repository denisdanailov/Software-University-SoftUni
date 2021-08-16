package DataTypesAndVariables.Labs;

import java.util.Scanner;

public class LowerOrUpperCase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        char character = input.charAt(0);
        String output = "";

        if (character >= 'a' && character <= 'z') {
            output = "lower-case";
        } else if (character >= 'A' && character <= 'Z') {
            output = "upper-case";
        }

        System.out.println(output);
    }
}
