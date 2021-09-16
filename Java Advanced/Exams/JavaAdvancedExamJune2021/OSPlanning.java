package JavaAdvancedExamJune2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int[] tasks = readIntArr(scan, ",\\s+");
        int[] threads = readIntArr(scan, "\\s+");

        ArrayDeque<Integer> taskStack = createStack(tasks);
        ArrayDeque<Integer> threadQueue = createQueue(threads);

        int taskToBeKilled = Integer.parseInt(scan.nextLine());
        // Logic
        boolean isTaskKilled = false;
        int winnerThread = 0;
        while (!isTaskKilled) {
            int task = taskStack.peek();
            int thread = threadQueue.peek();
            if (task == taskToBeKilled) {
                isTaskKilled = true;
                winnerThread = thread;
            } else if (thread >= task) {
                taskStack.pop();
                threadQueue.poll();
            } else {
                threadQueue.poll();
            }
        }
        // Print
        System.out.printf("Thread with value %d killed task %d%n", winnerThread, taskToBeKilled);
        threadQueue.forEach(e -> System.out.print(e + " "));
    }

    private static ArrayDeque<Integer> createQueue(int[] threads) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int thread : threads) {
            queue.offer(thread);
        }
        return queue;
    }

    private static ArrayDeque<Integer> createStack(int[] tasks) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int task : tasks) {
            stack.push(task);
        }
        return stack;
    }

    private static int[] readIntArr(Scanner scan, String delimiter) {
        String input = scan.nextLine();
        if (input.equals("")) {
            return new int[0];
        }
        return Arrays.stream(input.split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
