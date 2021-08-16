package MockExamsPB.July2020;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int points = 0;
        int countRed = 0;
        int countOrange = 0;
        int countYellow = 0;
        int countWhite = 0;
        int countDefault = 0;
        int countBlack = 0;

        for (int i = 0; i < n; i++) {
           String color = scan.nextLine();
           switch (color) {
               case "red":
                   points += 5;
                   countRed++;
                   break;
               case "orange":
                   points += 10;
                   countOrange++;
                   break;
               case "yellow":
                   points += 15;
                   countYellow++;
                   break;
               case "white":
                   points += 20 ;
                   countWhite++;
                   break;
               case "black":
                   points /= 2;
                   countBlack++;
                   break;
               default:
                   countDefault++;
                   break;
           }
        }
        System.out.printf("Total points: %d%n", points);
        System.out.printf("Points from red balls: %d%n", countRed);
        System.out.printf("Points from orange balls: %d%n", countOrange);
        System.out.printf("Points from yellow balls: %d%n", countYellow);
        System.out.printf("Points from white balls: %d%n", countWhite);
        System.out.printf("Other colors picked: %d%n", countDefault);
        System.out.printf("Divides from black balls: %d%n", countBlack);
    }
}
