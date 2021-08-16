package Methods.Labs;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        System.out.println(rectangleArea(a, b));
    }

    public static int rectangleArea(int a, int b) {
        return a * b;
    }
}
