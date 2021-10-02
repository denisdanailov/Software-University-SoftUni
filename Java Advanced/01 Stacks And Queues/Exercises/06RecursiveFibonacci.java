package StacksAndQueues.Exercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        memory = new long[n + 1];
        long fibonacci = getFibonacci(n);
        System.out.println(fibonacci);
    }

    private static long getFibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return memory[n];
    }
}
