package WhileLoop.Labs;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = scan.nextLine();
        String password = scan.nextLine();

        String input = "";

        while (!password.equals(input)) {
            input = scan.nextLine();
        }

        System.out.printf("Welcome %s!", username);
    }
}
