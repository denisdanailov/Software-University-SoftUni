package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = readArray(scan, "\\s+");
        // Create Consumer
        Consumer<int[]> sortArray = numbers -> {
            List<Integer> evenNumList = new ArrayList<>();
            List<Integer> oddNumList = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    evenNumList.add(numbers[i]);
                } else {
                    oddNumList.add(numbers[i]);
                }
            }
            evenNumList.stream().sorted().forEach(a-> System.out.print(a + " "));
            oddNumList.stream().sorted().forEach(a-> System.out.print(a + " "));
        };
        // Apply Consumer
        sortArray.accept(inputArr);
    }

    private static int[] readArray(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
