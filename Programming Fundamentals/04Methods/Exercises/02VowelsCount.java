package Methods.Exercises;

import java.util.Scanner;

public class vowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int result = countVowels(input);

        System.out.print(result);
    }

    public static int countVowels(String text) {
        int returnCount = 0;
        int textLength = text.length();
        for (int i = 0; i < textLength; i++) {
            char symbol = text.charAt(i);
            if (symbol == 'a' || symbol == 'o' || symbol == 'u' || symbol == 'e' || symbol == 'i' || symbol == 'A' || symbol == 'O' || symbol == 'U' || symbol == 'E' || symbol == 'I') {
                returnCount++;
            }
        }
        return returnCount;
    }
}
