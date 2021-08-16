package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        double coins = 0;
        double sumCoins = 0;

        while (!input.equals("Start")){
            coins = Double.parseDouble(input);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1.00 || coins == 2.00) {
                sumCoins += coins;
            } else {
                System.out.printf("Cannot accept %.02f%n", coins);
            }
            input = scan.nextLine();
        }

        String product = scan.nextLine();
        double price = 0;
        double productSum = 0;

        while (!product.equals("End")) {
            switch (product){
                case "Nuts":
                    price = 2.0;
                    productSum += price;
                    if (productSum > sumCoins){
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                    }
                    break;
                case "Water":
                    price = 0.7;
                    productSum += price;
                    if (productSum > sumCoins){
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                    }
                    break;
                case "Crisps":
                    price = 1.5;
                    productSum += price;
                    if (productSum > sumCoins){
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                    }
                    break;
                case "Soda":
                    price = 0.8;
                    productSum += price;
                    if (productSum > sumCoins){
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                    }
                    break;
                case "Coke":
                    price = 1.0;
                    productSum += price;
                    if (productSum > sumCoins){
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", product);
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            product = scan.nextLine();
        }

        System.out.printf("Change: %.02f%n", Math.abs(sumCoins-productSum));
    }
}
