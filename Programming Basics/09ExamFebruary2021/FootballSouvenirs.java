package ExamFebruary2021;

import java.util.Scanner;

public class FootballSouvenirs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String teams = scan.nextLine();
        String items = scan.nextLine();
        int itemsBought = Integer.parseInt(scan.nextLine());

        double price = 0;
        String output = "";

        switch (teams) {
            case "Argentina":
                switch (items) {
                    case "flags":
                        price = 3.25;
                        break;
                    case "caps":
                        price = 7.20;
                        break;
                    case "posters":
                        price = 5.10;
                        break;
                    case "stickers":
                        price = 1.25;
                        break;
                    default:
                        output = "Invalid stock!";
                        break;
                }
                break;
            case "Brazil":
                switch (items) {
                    case "flags":
                        price = 4.20;
                        break;
                    case "caps":
                        price = 8.50;
                        break;
                    case "posters":
                        price = 5.35;
                        break;
                    case "stickers":
                        price = 1.20;
                        break;
                    default:
                        output = "Invalid stock!";
                        break;
                }
                break;
            case "Croatia":
                switch (items) {
                    case "flags":
                        price = 2.75;
                        break;
                    case "caps":
                        price = 6.90;
                        break;
                    case "posters":
                        price = 4.95;
                        break;
                    case "stickers":
                        price = 1.10;
                        break;
                    default:
                        output = "Invalid stock!";
                        break;
                }
                break;
            case "Denmark":
                switch (items) {
                    case "flags":
                        price = 3.10;
                        break;
                    case "caps":
                        price = 6.50;
                        break;
                    case "posters":
                        price = 4.80;
                        break;
                    case "stickers":
                        price = 0.90;
                        break;
                    default:
                        output = "Invalid stock!";
                        break;
                }
                break;
            default:
                output = "Invalid country!";
                break;
        }

        double totalPrice = price * itemsBought;

        if (output.equals("Invalid country!")) {
            System.out.println("Invalid country!");
        } else if (output.equals("Invalid stock!")) {
            System.out.println("Invalid stock!");
        } else {
            System.out.printf("Pepi bought %d %s of %s for %.2f lv.", itemsBought, items, teams, totalPrice);
        }
    }
}
