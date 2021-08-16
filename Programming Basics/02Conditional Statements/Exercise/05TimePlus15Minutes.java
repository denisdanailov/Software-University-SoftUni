package ConditionalStatements.Exercises;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        int time = (hour * 60) + minutes;
        int timePlus15 = time + 15;
        int newHour = timePlus15 / 60;
        int newMinutes = timePlus15 % 60;

        if (newHour > 23) {
            newHour = 0;
        }

        if (newMinutes > 10) {
            System.out.printf("%d:%d", newHour, newMinutes);
        } else {
            System.out.printf("%d:%02d", newHour, newMinutes);
        }
    }
}
