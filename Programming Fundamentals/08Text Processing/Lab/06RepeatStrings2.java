package TextProcessing.Lab;

import java.util.Scanner;

public class RepeatStrings2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] wordArr = input.split(" ");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < wordArr.length; i++) {
            output.append(repeatString(wordArr[i], wordArr[i].length()));
        }

        System.out.println(output);
    }

    public static String repeatString(String word, int n) {
        String[] charArr = new String[n];
        for (int i = 0; i < n; i++) {
            charArr[i] = word;
        }
        return String.join("", charArr);
    }
}
