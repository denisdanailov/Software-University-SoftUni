package TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().split(" ");

        int sum = 0;

        if (words[0].length() == words[1].length()) {
            for (int i = 0; i < words[0].length(); i++) {
               sum += words[0].charAt(i) * words[1].charAt(i);
            }
        } else {
            if (words[0].length() > words[1].length()) {
                for (int i = 0; i < words[1].length(); i++) {
                    sum += words[0].charAt(i) * words[1].charAt(i);
                }
                for (int i = words[1].length(); i < words[0].length(); i++) {
                    sum += words[0].charAt(i);
                }
            } else {
                for (int i = 0; i < words[0].length(); i++) {
                    sum += words[0].charAt(i) * words[1].charAt(i);
                }
                for (int i = words[0].length(); i < words[1].length(); i++) {
                   sum += words[1].charAt(i);
                }
            }

        }

        System.out.println(sum);
    }
}
