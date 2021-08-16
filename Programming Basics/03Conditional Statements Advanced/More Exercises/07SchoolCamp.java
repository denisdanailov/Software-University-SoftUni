package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        String group = scan.nextLine();
        int students = Integer.parseInt(scan.nextLine());
        int nights = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (season) {
            case "Winter":
                switch (group) {
                    case "boys":
                    case "girls":
                        price = 9.60;
                        break;
                    case "mixed":
                        price = 10.0;
                        break;
                }
                break;
            case "Spring":
                switch (group) {
                    case "boys":
                    case "girls":
                        price = 7.20;
                        break;
                    case "mixed":
                        price = 9.50;
                        break;
                }
                break;
            case "Summer":
                switch (group) {
                    case "boys":
                    case "girls":
                        price = 15.0;
                        break;
                    case "mixed":
                        price = 20.0;
                        break;
                }
                break;
        }
        double totalPrice = (nights * price) * students;
        double discount = 0;

        if (students >= 50) {
            discount = totalPrice * 0.50;
        } else if (students >= 20 && students < 50) {
            discount = totalPrice * 0.15;
        } else if (students >= 10 && students < 20) {
            discount = totalPrice * 0.05;
        }

        totalPrice -= discount;
        String sport ="";

        switch (season) {
            case "Winter":
                switch (group) {
                    case "boys":
                        sport = "Judo";
                        break;
                    case "girls":
                        sport = "Gymnastics";
                        break;
                    case "mixed":
                        sport = "Ski";
                        break;
                }
                break;
            case "Spring":
                switch (group) {
                    case "boys":
                        sport = "Tennis";
                        break;
                    case "girls":
                        sport = "Athletics";
                        break;
                    case "mixed":
                        sport = "Cycling";
                        break;
                }
                break;
            case "Summer":
                switch (group) {
                    case "boys":
                        sport = "Football";
                        break;
                    case "girls":
                        sport = "Volleyball";
                        break;
                    case "mixed":
                        sport = "Swimming";
                        break;
                }
                break;
        }

        System.out.printf("%s %.2f lv.", sport, totalPrice);
    }
}
