package TextProcessing.Exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        char[] arr = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i);
            arr[i] += 3;
        }

        StringBuilder output = new StringBuilder();

        for (char a:
             arr) {
            output.append(a);
        }

        System.out.println(output);
    }
}
