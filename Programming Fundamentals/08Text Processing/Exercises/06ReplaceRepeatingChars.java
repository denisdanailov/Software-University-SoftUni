package TextProcessing.Exercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] charArr =input.split("");

        for (int i = charArr.length-1; i > 0; i--) {
            if (charArr[i].equals(charArr[i-1])) {
                StringBuilder charSequence = new StringBuilder();
                for (int j = 0; j < 2; j++) {
                    charSequence.append(charArr[i]);
                }
                input = input.replace(charSequence,charArr[i]);
            }
        }
        System.out.println(input);
    }
}
