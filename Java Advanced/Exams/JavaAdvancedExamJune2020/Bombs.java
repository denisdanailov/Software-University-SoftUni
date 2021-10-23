package Exams.JavaAdvancedExamJune2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] bombEffects = readArray(scan, ",\\s+");
        int[] bombCasing = readArray(scan, ",\\s+");

        ArrayDeque<Integer> queue = createQueue(bombEffects);
        ArrayDeque<Integer> stack = createStack(bombCasing);

        int sum = 0;
        int daturaCount = 0;
        int cherryCount = 0;
        int smokeDecoyCount = 0;
        boolean isPouchFilled = false;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            sum = queue.peek() + stack.peek();
            switch (sum) {
                case 40:
                    daturaCount++;
                    queue.poll();
                    stack.pop();
                    break;
                case 60:
                    cherryCount++;
                    queue.poll();
                    stack.pop();
                    break;
                case 120:
                    smokeDecoyCount++;
                    queue.poll();
                    stack.pop();
                    break;
                default:
                    int element = stack.pop() - 5;
                    stack.push(element);
                    break;
            }
            if (daturaCount >= 3 && cherryCount >= 3 && smokeDecoyCount >= 3) {
                isPouchFilled = true;
                break;
            }
        }

        //Print
        if (isPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + queue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (stack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.printf("Cherry Bombs: %d%n", cherryCount);
        System.out.printf("Datura Bombs: %d%n", daturaCount);
        System.out.printf("Smoke Decoy Bombs: %d", smokeDecoyCount);
    }

    private static ArrayDeque<Integer> createStack(int[] bombCasing) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < bombCasing.length; i++) {
            stack.push(bombCasing[i]);
        }
        return stack;
    }

    private static ArrayDeque<Integer> createQueue(int[] bombEffects) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bombEffects.length; i++) {
            queue.offer(bombEffects[i]);
        }
        return queue;
    }

    private static int[] readArray(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
