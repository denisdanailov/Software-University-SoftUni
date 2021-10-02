package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input1 = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = input1[0];
        int s = input1[1];
        int x = input1[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] input2 = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        // Stack Push
        for (int i = 0; i < n; i++) {
            queue.offer(input2[i]);
        }
        // Stack Pop
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        // Contains x?
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(findSmallestElement(queue));
        }
    }

    private static int findSmallestElement(ArrayDeque<Integer> queue) {
        int smallestInteger = Integer.MAX_VALUE;
        int queueLength = queue.size();
        for (int i = 0; i < queueLength; i++) {
            int currValue = queue.poll();
            if (smallestInteger > currValue) {
                smallestInteger = currValue;
            }
        }
        if (smallestInteger == Integer.MAX_VALUE) {
            return 0;
        }
        return smallestInteger;
    }
}
