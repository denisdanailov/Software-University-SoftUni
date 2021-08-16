package NestedLoops.Exercises;

import java.util.Scanner;

public class PyramidOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int num =0;

        boolean flag = false;

        for (int rows = 1; rows <= n; rows++) {
            for (int columns = 1; columns <= rows; columns++) {
                num++;
                if (num > n) {
                    flag = true;
                    break;
                }
                System.out.print(num + " ");
            }
            if (flag) {
                break;
            }
            System.out.println();
        }
    }
}
