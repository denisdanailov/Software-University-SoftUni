package TextProcessing.Exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scan.nextLine());
        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                power += Character.getNumericValue(input.charAt(i+1));
            } else if (input.charAt(i) != '>' && power > 0) {
                input.deleteCharAt(i);
                power -= 1;
                i -= 1;
            }
        }

        System.out.println(input);
    }
}
