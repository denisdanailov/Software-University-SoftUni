package Methods.Exercises;

import java.util.Scanner;

public class MiddleCharacter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        printMiddleCharacter(input);
    }

    public static void printMiddleCharacter(String input) {

        String[] arrOfStr = input.split("");
        int counter = 0;

            if (input.length() % 2 == 0) {
                System.out.print(arrOfStr[(input.length() - 1) / 2]);
                System.out.print(arrOfStr[((input.length() - 1) / 2) + 1]);
            } else {
                System.out.println(arrOfStr[(input.length() - 1) / 2] + " ");
            }


    }
}
