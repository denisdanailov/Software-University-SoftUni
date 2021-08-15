package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lenght = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        Double percent = Double.parseDouble(scan.nextLine());

        int volumeInCM = lenght * height * width;
        Double volumeLitres = volumeInCM * 0.001;
        Double newPercent = percent * 0.01;
        Double totalVolume = volumeLitres * (1-newPercent);

        System.out.printf("%.2f", totalVolume);

    }
}
