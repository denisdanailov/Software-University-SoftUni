package Methods.Exercises;

import java.util.Scanner;

public class charactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);

        printChar(first, second);
    }

    public static void printChar(char first, char second) {
        if (first < second) {
            for (char i = (char) (first + 1); i < second; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (second + 1); i < first; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
