package Exams.JavaAdvancedRetakeExamAugust2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] liliesArr = readArray(scan, ",\\s+");
        int[] rosesArr = readArray(scan, ",\\s+");

        ArrayDeque<Integer> liliesStack = createStack(liliesArr);
        ArrayDeque<Integer> rosesQueue = createQueue(rosesArr);

        int sum = 0;
        int storedFlowers = 0;
        int countWreaths = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
           sum = liliesStack.peek() + rosesQueue.peek();
           if (sum == 15) {
              countWreaths++;
              liliesStack.pop();
              rosesQueue.poll();
           } else if (sum > 15) {
               int lastElement = liliesStack.pop();
               liliesStack.push( lastElement - 2);
           } else {
               int lilies = liliesStack.pop();
               int roses = rosesQueue.poll();
               storedFlowers += lilies + roses;
           }
        }

        countWreaths += storedFlowers / 15;

        // Print
        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }
    }

    private static ArrayDeque<Integer> createQueue(int[] arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        return queue;
    }

    private static ArrayDeque<Integer> createStack(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        return stack;
    }

    private static int[] readArray(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
