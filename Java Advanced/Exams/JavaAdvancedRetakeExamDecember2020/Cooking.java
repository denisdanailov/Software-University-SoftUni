package Exams.JavaAdvancedRetakeExamDecember2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] liquidArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] ingredientArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> liquids = createQueue(liquidArr);
        ArrayDeque<Integer> ingredients = createStack(ingredientArr);

        int countBread = 0;
        int countCake = 0;
        int countPastry = 0;
        int countFruitPie = 0;
        String product = "";

        // Create map and make entries
        Map<String, Integer> mapFood = new LinkedHashMap<>();
        mapFood.put("Bread", countBread);
        mapFood.put("Cake", countCake);
        mapFood.put("Pastry", countPastry);
        mapFood.put("Fruit Pie", countFruitPie);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            boolean isValidSum = false;
            int sum = liquids.peek() + ingredients.peek();
            switch (sum) {
                case 25:
                    countBread++;
                    product = "Bread";
                    mapFood.replace(product, countBread);
                    isValidSum = true;
                    break;
                case 50:
                    countCake++;
                    product = "Cake";
                    mapFood.replace(product, countCake);
                    isValidSum = true;
                    break;
                case 75:
                    countPastry++;
                    product = "Pastry";
                    mapFood.replace(product, countPastry);
                    isValidSum = true;
                    break;
                case 100:
                    countFruitPie++;
                    product = "Fruit Pie";
                    mapFood.replace(product, countFruitPie);
                    isValidSum = true;
                    break;
            }

            liquids.poll();
            if (isValidSum) {
                ingredients.pop();
            } else {
               int currIngredient = ingredients.pop();
               ingredients.push(currIngredient + 3);
            }
        }

        // Print
        if (countBread > 0 && countCake > 0 && countPastry > 0 && countFruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> liquidsLeft = liquids.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Liquids left: " + String.join(", ", liquidsLeft));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> ingredientsLeft = ingredients.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Ingredients left: " + String.join(", ", ingredientsLeft));
        }

        mapFood.entrySet().stream()
                .sorted((a,b) -> a.getKey().compareTo(b.getKey()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }

    private static ArrayDeque<Integer> createStack(int[] ingredientArr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < ingredientArr.length; i++) {
            stack.push(ingredientArr[i]);
        }
        return stack;
    }

    private static ArrayDeque<Integer> createQueue(int[] liquidArr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < liquidArr.length; i++) {
            queue.offer(liquidArr[i]);
        }
        return queue;
    }
}
