package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if (tokens[0] == 1) {
                stack.push(tokens[1]);
            } else if (tokens[0] == 2) {
                stack.pop();
            } else if (tokens[0] == 3) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
