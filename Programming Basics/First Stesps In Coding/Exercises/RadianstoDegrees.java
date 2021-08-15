package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class RadianstoDegrees {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Double radian = Double.parseDouble(scan.nextLine());

        Double degree = radian * 180 / Math.PI;

        System.out.printf("%.0f",degree);
    }
}
