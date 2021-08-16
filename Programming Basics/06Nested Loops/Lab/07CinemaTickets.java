package NestedLoops.Labs;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        double countStudents = 0;
        double countStandard = 0;
        double countKids = 0;

        while (!input.equals("Finish")) {
            String movieName = input;
            double seats = Integer.parseInt(scan.nextLine());
            double sumSeats = 0;
            while (seats > sumSeats) {
                input = scan.nextLine();

                if (input.equals("End")) {
                    break;
                }
                sumSeats++;
                switch (input) {
                    case "student":
                        countStudents++;
                        break;
                    case "standard":
                        countStandard++;
                        break;
                    case "kid":
                        countKids++;
                        break;
                }
            }
            double average = (sumSeats / seats) * 100;
            System.out.printf("%s - %.2f%% full.%n", movieName, average);
            input = scan.nextLine();
        }
        double totalTickets = countKids + countStudents + countStandard;
        System.out.printf("Total tickets: %.0f%n", totalTickets);
        double avgStudents = (countStudents / totalTickets)*100;
        System.out.printf("%.2f%% student tickets.%n", avgStudents);
        double avgStandard = (countStandard / totalTickets)*100;
        System.out.printf("%.2f%% standard tickets.%n", avgStandard);
        double avgKids = (countKids / totalTickets)*100;
        System.out.printf("%.2f%% kids tickets.%n", avgKids);
    }
}
