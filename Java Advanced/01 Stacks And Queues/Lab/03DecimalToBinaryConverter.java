package StacksandQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number > 0) {
            while (number > 0) {
                int binaryResult = number % 2;
                stack.push(binaryResult);
                number /= 2;
            }
        } else {
            System.out.println(0);
        }

        for (int num:
             stack) {
          System.out.print(num);
        }
    }
}
