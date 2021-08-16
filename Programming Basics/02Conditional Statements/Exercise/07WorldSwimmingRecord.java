package ConditionalStatements.Exercises;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double seconds = Double.parseDouble(scan.nextLine());

        double time = distance * seconds;
        double resistance = (Math.floor(distance / 15)) * 12.5;
        double totalTime = time + resistance;

        if (totalTime < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.02f seconds.", totalTime);
        } else {
            System.out.printf("No, he failed! He was %.02f seconds slower.", totalTime - record);
        }
    }
}

