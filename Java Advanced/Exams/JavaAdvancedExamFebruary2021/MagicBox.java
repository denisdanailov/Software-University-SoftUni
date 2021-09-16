package Exams.JavaAdvancedExamFebruary2021;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstBox = readInputArr(scan);
        int[] secondBox = readInputArr(scan);

        ArrayDeque<Integer> firstBoxQueue = createQueue(firstBox);
        ArrayDeque<Integer> secondBoxStack = createStack(secondBox);
        // Logic
        ArrayList<Integer> collection = new ArrayList<>();
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int sum = firstBoxQueue.peek() + secondBoxStack.peek();
            if (sum % 2 == 0) {
                collection.add(sum);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                int itemRemoved = secondBoxStack.pop();
                firstBoxQueue.offer(itemRemoved);
            }
        }
        // Print
        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        int sum = collection.stream().mapToInt(e -> e).sum();
        if (sum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sum);
        }
    }

    private static ArrayDeque<Integer> createStack(int[] secondBox) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < secondBox.length; i++) {
            stack.push(secondBox[i]);
        }
        return stack;
    }

    private static ArrayDeque<Integer> createQueue(int[] firstBox) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < firstBox.length; i++) {
            queue.offer(firstBox[i]);
        }
        return queue;
    }

    private static int[] readInputArr(Scanner scan) {
        String input = scan.nextLine();
        if (!input.equals("")) {
            return Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        } else {
            return new int[0];
        }
    }
}
