package workingWithAbstraction.lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coordinatesInput = readIntArr(scan);

        Rectangle rect = new Rectangle(coordinatesInput);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            int[] coordinates = readIntArr(scan);
            Point newPoint = new Point(coordinates[0], coordinates[1]);
            System.out.println(rect.contains(newPoint));
        }
    }

    private static int[] readIntArr(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
