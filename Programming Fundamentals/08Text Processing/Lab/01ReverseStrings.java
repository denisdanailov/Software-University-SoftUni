package TextProcessing.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("end")) {
            char[] charArr = new char[input.length()];
            for (int i = 0; i < charArr.length; i++) {
                charArr[i] = input.charAt(i);
            }

            char[] reversArr = new char[charArr.length];
            int j = -1;
            for (int i = charArr.length - 1; i >= 0; i--) {
                j++;
                reversArr[j] = charArr[i];
            }

            String output = new String(reversArr);

            System.out.println(input + " = " + output);

            input = scan.nextLine();
        }

    }
}
