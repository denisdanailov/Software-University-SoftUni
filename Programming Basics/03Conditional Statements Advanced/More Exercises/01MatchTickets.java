package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String ticket = scan.nextLine();
        int numPeople = Integer.parseInt(scan.nextLine());

        double costTransport = 0;

        if(numPeople >= 1 && numPeople <=4) {
            costTransport = budget * 0.75;
        } else if (numPeople >= 5 && numPeople <= 9) {
            costTransport = budget * 0.60;
        } else if (numPeople >= 10 && numPeople <= 24) {
            costTransport = budget * 0.50;
        } else if (numPeople >= 25 && numPeople <= 49) {
            costTransport = budget * 0.40;
        } else if (numPeople >= 50) {
            costTransport = budget * 0.25;
        }

        budget -= costTransport;
        double costTickets = 0;

        if (ticket.equals("VIP")) {
            costTickets = numPeople * 499.99;
        } else if (ticket.equals("Normal")) {
            costTickets = numPeople * 249.99;
        }

        if(budget >= costTickets) {
            double moneyLeft = budget - costTickets;
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            double moneyNeeded = costTickets - budget;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
        }
    }
}
