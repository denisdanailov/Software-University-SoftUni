package BasicSyntaxConditionalStatementsAndLoops.Labs;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int totalTime = (hours * 60) + minutes;
        int newTime = totalTime + 30;

        int newHours = newTime / 60;
        int newMinutes = newTime % 60;

        if (newHours > 23) {
            newHours = 0;
        }

        if (newMinutes > 59) {
            newMinutes = 0;
        }

        System.out.printf("%d:%02d%n",newHours, newMinutes);
    }
}
