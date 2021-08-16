package WhileLoop.Labs;

import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Stop")) {
                break;
            } else {
                System.out.println(input);
            }
        }
    }
}
