package Methods.Labs;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String order = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());

        printTotalPrice(order, quantity);
    }

    public static void printTotalPrice(String text, int n) {
        double price = 0;
        switch (text) {
            case "coffee":
                price = 1.50;
                break;
            case "water":
                price = 1.00;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2.00;
                break;
        }
        double totalPrice = price * n;

        System.out.printf("%.02f", totalPrice);
    }
}
