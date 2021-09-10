package Exams.JavaAdvancedExamFebruary2020;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read
        int[] lootBox1 = readInput(scan);
        int[] lootBox2 = readInput(scan);

        ArrayDeque<Integer> lootBox1Queue = createQueue(lootBox1);
        ArrayDeque<Integer> lootBox2Stack = createStack(lootBox2);
        // Logic
        List<Integer> lootList = new ArrayList<>();
        while (!lootBox1Queue.isEmpty() && !lootBox2Stack.isEmpty()) {
            int itemLootBox1 = lootBox1Queue.peek();
            int itemLootBox2 = lootBox2Stack.peek();
            int sum = itemLootBox1 + itemLootBox2;
            if (sum % 2 == 0) {
                lootList.add(sum);
                lootBox1Queue.poll();
                lootBox2Stack.pop();
            } else {
                int addItem = lootBox2Stack.pop();
                lootBox1Queue.offer(addItem);
            }
        }
        if (lootBox1Queue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        int sumLoot = lootList.stream().mapToInt(e -> e).sum();
        if (sumLoot >= 100) {
            System.out.println("Your loot was epic! Value: " + sumLoot);
        } else {
            System.out.println("Your loot was poor... Value: " + sumLoot);
        }
    }

    private static ArrayDeque<Integer> createStack(int[] lootBox2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < lootBox2.length; i++) {
            stack.push(lootBox2[i]);
        }
        return stack;
    }

    private static ArrayDeque<Integer> createQueue(int[] lootBox1) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < lootBox1.length; i++) {
            queue.offer(lootBox1[i]);
        }
        return queue;
    }

    private static int[] readInput(Scanner scan) {
        String input = scan.nextLine();
        if (input.equals("")) {
            return new int[0];
        } else {
            return Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
