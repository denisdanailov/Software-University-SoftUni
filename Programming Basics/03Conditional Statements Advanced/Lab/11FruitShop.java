package AdvConditionalStatements.Labs;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruit = scan.nextLine();
        String day = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());

        double priceFruit = 0;
        String error = "";

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if (fruit.equals("banana")) {
                    priceFruit = quantity * 2.50;
                } else if (fruit.equals("apple")) {
                    priceFruit = quantity * 1.20;
                } else if (fruit.equals("orange")) {
                    priceFruit = quantity * 0.85;
                } else if (fruit.equals("grapefruit")) {
                    priceFruit = quantity * 1.45;
                } else if (fruit.equals("kiwi")) {
                    priceFruit = quantity * 2.70;
                } else if (fruit.equals("pineapple")) {
                    priceFruit = quantity * 5.50;
                } else if (fruit.equals("grapes")){
                    priceFruit = quantity * 3.85;
                } else {
                    error = "error";
                    System.out.println("error");
                }
                break;
            case "Saturday":
            case "Sunday":
                if (fruit.equals("banana")) {
                    priceFruit = quantity * 2.70;
                } else if (fruit.equals("apple")) {
                    priceFruit = quantity * 1.25;
                } else if (fruit.equals("orange")) {
                    priceFruit = quantity * 0.90;
                } else if (fruit.equals("grapefruit")) {
                    priceFruit = quantity * 1.60;
                } else if (fruit.equals("kiwi")) {
                    priceFruit = quantity * 3;
                } else if (fruit.equals("pineapple")) {
                    priceFruit = quantity * 5.60;
                } else if (fruit.equals("grapes")){
                    priceFruit = quantity * 4.20;
                } else {
                    error = "error";
                    System.out.println("error");
                }
                break;
            default:
                error = "error";
                System.out.println(error);
        }
        if (!error.equals("error")) {
            System.out.printf("%.2f", priceFruit);
        } else {
            System.out.println("");
        }
    }
}
