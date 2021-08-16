package MockExamsPB.July2020;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String delivery = scan.nextLine();

        double price = 0;
        double totalPrice = 0;
        double discount = 0;

        if (num < 10) {
            System.out.println("Invalid order");
        } else {
            switch (type) {
                case "90X130":
                    price = 110;
                    totalPrice = price * num;
                    if (num > 60) {
                        discount = totalPrice * 0.08;
                    } else if (num > 30) {
                        discount = totalPrice * 0.05;
                    }
                    break;
                case "100X150":
                    price = 140;
                    totalPrice = price * num;
                    if (num > 80) {
                        discount = totalPrice * 0.10;
                    } else if (num > 40) {
                        discount = totalPrice * 0.06;
                    }
                    break;
                case "130X180":
                    price = 190;
                    totalPrice = price * num;
                    if (num > 50) {
                        discount = totalPrice * 0.12;
                    } else if (num > 20) {
                        discount = totalPrice * 0.07;
                    }
                    break;
                case "200X300":
                    price = 250;
                    totalPrice = price * num;
                    if (num > 50) {
                        discount = totalPrice * 0.14;
                    } else if (num > 25) {
                        discount = totalPrice * 0.09;
                    }
                    break;
            }
            totalPrice -= discount;

            switch (delivery) {
                case "With delivery":
                    totalPrice += 60;
                    break;
                case "Without delivery":
                    break;
            }

            if (num > 99) {
                totalPrice -= totalPrice * 0.04;
            }

            System.out.printf("%.2f BGN%n", totalPrice);
        }
    }
}
