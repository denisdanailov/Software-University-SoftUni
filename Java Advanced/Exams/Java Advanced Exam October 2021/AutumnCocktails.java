package Exams.JavaAdvancedExamOctober2021RegularExam;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] bucket = readArr(scan);
        int[] freshnessLevel = readArr(scan);

        ArrayDeque<Integer> queue = createQueue(bucket);
        ArrayDeque<Integer> stack = createStack(freshnessLevel);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Pear Sour", 0);
        map.put("The Harvest", 0);
        map.put("Apple Hinny", 0);
        map.put("High Fashion", 0);

        int sum = 0;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            sum = queue.peek() * stack.peek();
            String cocktail = "";
            int currCount = 0;
            switch (sum) {
                case 150:
                    cocktail = "Pear Sour";
                    currCount = map.get(cocktail);
                    map.replace(cocktail, currCount + 1);
                    queue.poll();
                    stack.pop();
                    break;
                case 250:
                    cocktail = "The Harvest";
                    currCount = map.get(cocktail);
                    map.replace(cocktail, currCount + 1);
                    queue.poll();
                    stack.pop();
                    break;
                case 300:
                    cocktail = "Apple Hinny";
                    currCount = map.get(cocktail);
                    map.replace(cocktail, currCount + 1);
                    queue.poll();
                    stack.pop();
                    break;
                case 400:
                    cocktail = "High Fashion";
                    currCount = map.get(cocktail);
                    map.replace(cocktail, currCount + 1);
                    queue.poll();
                    stack.pop();
                    break;
                default:
                    int ingredient = queue.poll();
                    if (ingredient != 0) {
                        stack.pop();
                        queue.offer(ingredient + 5);
                    }
                    break;
            }
        }

        // Print
        if (map.get("Pear Sour") > 0 && map.get("The Harvest") > 0 && map.get("Apple Hinny") > 0 &&
                map.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!queue.isEmpty()) {
            System.out.println("Ingredients left: " + queue.stream().mapToInt(e -> e).sum());
        }

        map.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()));
    }

    private static ArrayDeque<Integer> createStack(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        return stack;
    }

    private static ArrayDeque<Integer> createQueue(int[] arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        return queue;
    }

    private static int[] readArr(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
