package NestedLoops.MoreExercises;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int M = Integer.parseInt(scan.nextLine());

        int count = 0;
        boolean flag = false;
        int a1 = 1;
        int b1 = 1;
        int c1 = 1;
        int d1 = 1;

        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        if ((a * b + c * d) == M) {
                            if (a < b && c > d) {
                                count++;
                                System.out.printf("%d%d%d%d ", a, b, c, d);

                                if (count == 4) {
                                    flag = true;
                                    a1 = a;
                                    b1 = b;
                                    c1 = c;
                                    d1 = d;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("");
        if (flag) {
            System.out.printf("Password: %d%d%d%d", a1, b1, c1, d1);
        } else {
            System.out.println("No!");
        }
    }
}