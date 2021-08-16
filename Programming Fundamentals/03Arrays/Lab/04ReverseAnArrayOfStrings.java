package Arrays.Labs;

import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] symbols = input.split(" ");

//        for (int i = symbols.length-1; i >= 0; i--) {
//            System.out.print(symbols[i] + " ");
//        }

        for (int i = 0; i < symbols.length / 2; i++) {
            String swap = symbols[i];
            symbols[i] = symbols[symbols.length - 1 - i];
            symbols[symbols.length - 1 - i] = swap;
        }

        for (int i = 0; i < symbols.length; i++) {
            System.out.print(symbols[i] + " ");
        }
    }
}
