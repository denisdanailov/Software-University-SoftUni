package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String year = scan.nextLine();
        int r = Integer.parseInt(scan.nextLine());
        int h = Integer.parseInt(scan.nextLine());

        //48 weekends
        double weekendsSofia = 48 - h;
        double volleyballMatchesSofia = weekendsSofia * 3.0 / 4;
        double holidayMatchesSofia = r * 2.0 / 3;

        double totalMatches = volleyballMatchesSofia + holidayMatchesSofia + h;

        double additionalMatches = 0;
        if (year.equals("leap")) {
            additionalMatches = totalMatches * 0.15;
        }
        totalMatches = totalMatches + additionalMatches;

        System.out.printf("%.0f", Math.floor(totalMatches));
    }
}
