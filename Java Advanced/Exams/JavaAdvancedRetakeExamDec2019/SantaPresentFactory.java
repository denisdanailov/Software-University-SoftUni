package Exams.JavaAdvancedRetakeExamDec2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] boxWithMaterials = readArray(scan);
        int[] magicLevelValue = readArray(scan);

        ArrayDeque<Integer> stack = createStack(boxWithMaterials);
        ArrayDeque<Integer> queue = createQueue(magicLevelValue);

        int sum = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Doll", 0);
        map.put("Wooden train", 0);
        map.put("Teddy bear", 0);
        map.put("Bicycle", 0);

        while (!stack.isEmpty() && !queue.isEmpty()) {
            sum = stack.peek() * queue.peek();
            String product = "";
            int currCount = 0;
            switch (sum) {
                case 150:
                    product = "Doll";
                    currCount = map.get(product);
                    map.replace(product, currCount + 1);
                    stack.pop();
                    queue.poll();
                    break;
                case 250:
                    product = "Wooden train";
                    currCount = map.get(product);
                    map.replace(product, currCount + 1);
                    stack.pop();
                    queue.poll();
                    break;
                case 300:
                    product = "Teddy bear";
                    currCount = map.get(product);
                    map.replace(product, currCount + 1);
                    stack.pop();
                    queue.poll();
                    break;
                case 400:
                    product = "Bicycle";
                    currCount = map.get(product);
                    map.replace(product, currCount + 1);
                    stack.pop();
                    queue.poll();
                    break;
                default:
                    if (stack.peek() == 0 && queue.peek() == 0) {
                        stack.pop();
                        queue.poll();
                        break;
                    } else if (stack.peek() == 0) {
                        stack.pop();
                        break;
                    } else if (queue.peek() == 0) {
                        queue.poll();
                        break;
                    }
                    if (sum < 0) {
                        sum = stack.pop() + queue.poll();
                        stack.push(sum);
                    } else {
                        queue.poll();
                        int newMaterial = stack.pop() + 15;
                        stack.push(newMaterial);
                    }
                    break;
            }
        }

        // Print
        if (map.get("Teddy bear") > 0 && map.get("Bicycle") > 0 ||
                map.get("Doll") > 0 && map.get("Wooden train") > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!stack.isEmpty()) {
           System.out.println("Materials left: " + stack.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(", ")));
        }

        if (!queue.isEmpty()) {
            System.out.println("Magic left: " + queue.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(", ")));
        }

        map.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> System.out.printf("%s: %d%n",e.getKey(), e.getValue()));
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

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
