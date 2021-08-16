package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class SleepyCatTom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int nonWorkingDays = Integer.parseInt(scan.nextLine());
        //Решение
        int nonWorkingDaysMin = nonWorkingDays * 127;
        int workingDaysMin = (365 - nonWorkingDays) * 63;
        int totalPlayMinutes = nonWorkingDaysMin + workingDaysMin;
        int playNorm = 30000;
        //Проверки
        if (totalPlayMinutes > playNorm) {
            int morePlayTime = totalPlayMinutes - playNorm;
            int newHours = morePlayTime / 60;
            int newMinutes = morePlayTime % 60;
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", newHours, newMinutes);
        } else {
            int lessPlayTime = playNorm - totalPlayMinutes;
            int newHours = lessPlayTime / 60;
            int newMinutes = lessPlayTime % 60;
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", newHours, newMinutes);
        }
    }
}
