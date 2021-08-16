package WhileLoop.Labs;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int placeWidth = Integer.parseInt(scan.nextLine());
        int placeLength = Integer.parseInt(scan.nextLine());
        int placeHeight = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        int spaceAvailable = placeHeight * placeLength * placeWidth;
        int spaceNeeded = 0;
        int boxes = 0;

        while (!input.equals("Done")) {

            if (input.equals("Done")) {
                break;
            } else {
                boxes = Integer.parseInt(input);
            }

            spaceNeeded += boxes;

            if (spaceAvailable < spaceNeeded) {
                break;
            }

            input = scan.nextLine();
        }

        if (input.equals("Done")) {
            int spaceLeft = spaceAvailable - spaceNeeded;
            System.out.printf("%d Cubic meters left.", spaceLeft);
        } else if (spaceAvailable < spaceNeeded) {
            int neededSpace = spaceNeeded - spaceAvailable;
            System.out.printf("No more free space! You need %d Cubic meters more.", neededSpace);
        }
    }
}
