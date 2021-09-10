package Exams.JavaAdvancedRetakeExamAugust2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Reading
        List<Integer> liquids = readInput(scan);
        List<Integer> ingredients = readInput(scan);

        ArrayDeque<Integer> liquidsQueue = getQueue(liquids);
        ArrayDeque<Integer> ingredientsStack = getStack(ingredients);
        Map<String, Integer> pastryMap = new LinkedHashMap<>();
        pastryMap.put("Biscuit", 0);
        pastryMap.put("Cake", 0);
        pastryMap.put("Pie", 0);
        pastryMap.put("Pastry", 0);
        // Logic
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquid + ingredient;
            String pastry = "";
            boolean validPastry = false;
            switch (sum) {
                case 25:
                    validPastry = true;
                    pastry = "Biscuit";
                    addPastryToMap(pastryMap, pastry);
                    break;
                case 50:
                    validPastry = true;
                    pastry = "Cake";
                    addPastryToMap(pastryMap, pastry);
                    break;
                case 75:
                    validPastry = true;
                    pastry = "Pastry";
                    addPastryToMap(pastryMap, pastry);
                    break;
                case 100:
                    validPastry = true;
                    pastry = "Pie";
                    addPastryToMap(pastryMap, pastry);
                    break;
            }
            if (!validPastry) {
                ingredient += 3;
                ingredientsStack.push(ingredient);
            }
        }
        // Printing
        if (pastryMap.get("Biscuit") > 0 && pastryMap.get("Cake") > 0 && pastryMap.get("Pie") > 0 && pastryMap.get("Pastry") > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            printLiquidsLeft(liquidsQueue);
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            printIngredientsLeft(ingredientsStack);
        }
        printpastryMap(pastryMap);
    }

    private static void printpastryMap(Map<String, Integer> pastryMap) {
        pastryMap.entrySet()
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }

    private static void printIngredientsLeft(ArrayDeque<Integer> ingredientsStack) {
        for (int i = ingredientsStack.size() - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(ingredientsStack.pop() + ", ");
            } else {
                System.out.print(ingredientsStack.pop());
            }
        }
        System.out.println();
    }

    private static void printLiquidsLeft(ArrayDeque<Integer> liquidsQueue) {
        for (int i = liquidsQueue.size() - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(liquidsQueue.poll() + ", ");
            } else {
                System.out.print(liquidsQueue.poll());
            }
        }
        System.out.println();
    }

    private static void addPastryToMap(Map<String, Integer> pastryMap, String pastry) {
        if (pastryMap.containsKey(pastry)) {
            int currAmount = pastryMap.get(pastry);
            pastryMap.put(pastry, currAmount + 1);
        }
    }

    private static ArrayDeque<Integer> getStack(List<Integer> list) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        return stack;
    }

    private static ArrayDeque<Integer> getQueue(List<Integer> list) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }
        return queue;
    }

    private static List<Integer> readInput(Scanner scan) {
        String input = scan.nextLine();
        if (!input.equals("")) {
            return Arrays.stream(input.split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
