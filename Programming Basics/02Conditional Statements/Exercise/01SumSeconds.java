package ConditionalStatements.Exercises;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int racer1 = Integer.parseInt(scan.nextLine());
        int racer2 = Integer.parseInt(scan.nextLine());
        int racer3 = Integer.parseInt(scan.nextLine());

        int totalTime = racer1 + racer2 + racer3;
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        if (seconds < 10){
            System.out.printf("%d:0%d",minutes,seconds);
        } else {
            System.out.printf("%d:%d",minutes,seconds);
        }
    }
}
