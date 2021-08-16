package AdvConditionalStatements.MoreExercises;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());

        boolean firstCondition = (x == x1 || x == x2) && (y >= y1 && y <= y2);
        boolean secondCondition = (y == y1 || y == y2) && (x >= x1 && x <= x2);

        if (firstCondition || secondCondition) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
