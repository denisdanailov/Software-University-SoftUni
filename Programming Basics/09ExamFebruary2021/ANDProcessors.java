package ExamFebruary2021;

import java.util.Scanner;

public class ANDProcessors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int processorsPlanned = Integer.parseInt(scan.nextLine());
        int staff = Integer.parseInt(scan.nextLine());
        int workDays = Integer.parseInt(scan.nextLine());

        double totalHours = staff * workDays * 8;
        double processorsManufactured = Math.floor(totalHours / 3);

        double diff = Math.abs(processorsManufactured - processorsPlanned) * 110.10;

        if (processorsManufactured >= processorsPlanned) {
            System.out.printf("Profit: -> %.2f BGN", diff);
        } else {
            System.out.printf("Losses: -> %.2f BGN", diff);
        }
    }
}
