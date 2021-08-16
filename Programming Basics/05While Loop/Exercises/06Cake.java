package WhileLoop.Exercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(scan.nextLine());
        int cakeLength = Integer.parseInt(scan.nextLine());

        int cakeSize = cakeWidth * cakeLength;
        String input = "";
        int pieces = 0;
        int sumPieces = 0;

        while (sumPieces <= cakeSize) {

            input = scan.nextLine();

            if (!input.equals("STOP")) {
                pieces = Integer.parseInt(input);
            } else {
                break;
            }

            sumPieces += pieces;
        }

        if (sumPieces >= cakeSize) {
            int diff = sumPieces - cakeSize;
            System.out.printf("No more cake left! You need %d pieces more.", diff);
        } else {
            int diff = sumPieces - cakeSize;
            System.out.printf("%d pieces are left.", Math.abs(diff));
        }
    }
}
