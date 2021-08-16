package PreExamPreparation;

import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String city = scan.nextLine();
        String type = scan.nextLine();
        String VipOrNo = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());

        double price = 0;
        double discount = 0;
        String output = "";
        boolean flag = false;

        switch (city) {
            case "Bansko":
            case "Borovets":
                switch (type) {
                    case "withEquipment":
                        price = 100;
                        discount = price * 0.10;
                        break;
                    case "noEquipment":
                        price = 80;
                        discount = price * 0.05;
                        break;
                    default:
                        output = "Invalid input!";
                        flag = true;
                        break;
                }
                break;
            case "Varna":
            case "Burgas":
                switch (type) {
                    case "withBreakfast":
                        price = 130;
                        discount = price * 0.12;
                        break;
                    case "noBreakfast":
                        price = 100;
                        discount = price * 0.07;
                        break;
                    default:
                        output = "Invalid input!";
                        flag = true;
                        break;
                }
                break;
            default:
                output = "Invalid input!";
                flag = true;
                break;
        }

        if (VipOrNo.equals("yes")) {
            price -= discount;
        }

        double totalPrice = 0;

        if (days > 7) {
            totalPrice = price * (days - 1);
        } else {
            totalPrice = price * days;
        }

        if (days <= 1) {
            System.out.println("Days must be positive number!");
        } else if (flag) {
            System.out.println(output);
        } else {
            System.out.printf("The price is %.2flv! Have a nice time!", totalPrice);
        }
    }
}
