package BasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int group = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String day = scan.nextLine();

        double price = 0;

        switch (type){
            case"Students":
                switch (day){
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day){
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (day){
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }

        double totalPrice = price * group;

        if (type.equals("Students") && group >= 30) {
          totalPrice -= totalPrice*0.15;
        }
        if (type.equals("Business") && group >= 100) {
            totalPrice = price * (group - 10);
        }
        if (type.equals("Regular") && group >= 10 && group <= 20) {
            totalPrice -= totalPrice*0.05;
        }

        System.out.printf("Total price: %.02f%n", totalPrice);
    }
}
