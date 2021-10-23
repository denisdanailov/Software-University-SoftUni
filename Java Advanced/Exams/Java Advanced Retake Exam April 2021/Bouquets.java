package Exams.JavaAdvancedRetakeExamApril2021;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int[] tulipsArr = readInput(scan);
        int[] daffodilsArr = readInput(scan);

        ArrayDeque<Integer> tulipStack = createStack(tulipsArr);
        ArrayDeque<Integer> daffodilQueue = createQueue(daffodilsArr);
        // Logic
        int countBouquets = 0;
        ArrayList<Integer> flowers = new ArrayList<>();
        while (!tulipStack.isEmpty() || !daffodilQueue.isEmpty()) {
            int tulips = tulipStack.peek();
            int daffodils = daffodilQueue.peek();
            int sum = tulips + daffodils;
            if (sum == 15) {
                // Equal to 15
                countBouquets++;
                tulipStack.pop();
                daffodilQueue.poll();
            } else if (sum < 15) {
                // More Than 15
                flowers.add(sum);
                tulipStack.pop();
                daffodilQueue.poll();
            } else {
                // Less Than 15
                while (sum > 15) {
                    tulips -= 2;
                    sum = tulips + daffodils;
                }
                if (sum == 15) {
                    countBouquets++;
                    tulipStack.pop();
                    daffodilQueue.poll();
                } else {
                    flowers.add(sum);
                    tulipStack.pop();
                    daffodilQueue.poll();
                }
            }
        }
        int sumFlowers = flowers.stream().mapToInt(e -> e).sum();
        int addBouquets = sumFlowers / 15;
        countBouquets += addBouquets;

        if (countBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", countBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - countBouquets);
        }
    }

    private static ArrayDeque<Integer> createQueue(int[] daffodils) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < daffodils.length; i++) {
            queue.offer(daffodils[i]);
        }
        return queue;
    }

    private static ArrayDeque<Integer> createStack(int[] tulips) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tulips.length; i++) {
            stack.push(tulips[i]);
        }
        return stack;
    }

    private static int[] readInput(Scanner scan) {
        String input = scan.nextLine();
        if (!input.equals("")) {
            return Arrays.stream(input.split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return new int[0];
    }
}
