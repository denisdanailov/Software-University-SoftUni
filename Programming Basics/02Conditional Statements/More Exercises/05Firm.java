package ConditionalStatements.MoreExercises;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Вход
        int requiredHours = Integer.parseInt(scan.nextLine());
        int workDays = Integer.parseInt(scan.nextLine());
        int overtimeWorkers = Integer.parseInt(scan.nextLine());
        //Решение
        double workDaysAvailable = workDays - (workDays*0.10);
        double workHoursAvailable = workDaysAvailable * 8;
        double overtimeHoursAvailable = overtimeWorkers * (2*workDays);
        double totalHoursAvailable = workHoursAvailable + overtimeHoursAvailable;
        //Проверка
        if (totalHoursAvailable >= requiredHours) {
            double hoursLeft = Math.floor(totalHoursAvailable - requiredHours);
            System.out.printf("Yes!%.0f hours left.",hoursLeft);
        } else {
            double timeNeeded = requiredHours - totalHoursAvailable;
            System.out.printf("Not enough time!%.0f hours needed.", Math.ceil(timeNeeded));
        }
    }
}
