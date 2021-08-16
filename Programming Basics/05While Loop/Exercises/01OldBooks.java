package WhileLoop.Exercises;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String desiredBook = scan.nextLine();

        String randomBooks = "";
        int count = 0;

        while (!randomBooks.equals(desiredBook) && !randomBooks.equals("No More Books")) {

            randomBooks = scan.nextLine();

            if (randomBooks.equals(desiredBook)) {
                break;
            }
            if (randomBooks.equals("No More Books")) {
                break;
            }

            count++;
        }

        if (randomBooks.equals(desiredBook)) {
            System.out.printf("You checked %d books and found it.", count);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", count);
        }
    }
}
