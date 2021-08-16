package WhileLoop.Labs;

import java.util.Scanner;

public class MinNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int minValue = Integer.MAX_VALUE;

        while (!input.equals("Stop")) {

            int num = Integer.parseInt(input);

            if (num < minValue) {
                minValue = num;
            }

            input = scan.nextLine();
        }
        System.out.println(minValue);
    }
}
