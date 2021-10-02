package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] n = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = createStack(n);

        int stackLength = stack.size();
        for (int i = 0; i < stackLength; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static ArrayDeque<Integer> createStack(int[] n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int j : n) {
            stack.push(j);
        }
        return stack;
    }
}
