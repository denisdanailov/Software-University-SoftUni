package Exams.MidExam.ProgrammingFundamentalsMidExam01;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double price = 0;
        double sum = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                sum += price;
            }
            input = scan.nextLine();
        }

        double vatTax = sum * 0.20;
        double totalPrice = sum + vatTax;
        if (input.equals("special")) {
            double discount = totalPrice * 0.10;
            totalPrice -= discount;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.02f$%n" +
                    "Taxes: %.02f$%n" +
                    "-----------%n" +
                    "Total price: %.02f$%n", sum, vatTax, totalPrice);
        }
    }
}
