package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SecretDoorLock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int end100s = Integer.parseInt(scan.nextLine());
        int end10s = Integer.parseInt(scan.nextLine());
        int end1s = Integer.parseInt(scan.nextLine());

        boolean isPrime = false;

        for (int i = 1; i <= end100s; i++) {
            for (int j = 1; j <= end10s; j++) {
                for (int k = 1; k <= end1s; k++) {
                    for (int l = 1; l < end10s; l++) {
                        if (j > 2 && j < 7 && j % l == 0) {
                            isPrime = true;
                        }
                    }
                    if (i % 2 == 0 && k % 2 == 0 && isPrime) {
                        System.out.printf("%d%d%d%n", i, j, k);
                    }
                }
            }
        }
    }
}
