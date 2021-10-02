package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = readArray(scan, "\\s+");
        int n = Integer.parseInt(scan.nextLine());
        // Create Function reverse matrix
        Function<int[], int[]> reverseArray = numbers -> {
            List<Integer> list = new ArrayList<>();
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] % n != 0) {
                    list.add(numbers[i]);
                }
            }
            int[] newArray = new int[list.size()];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = list.get(i);
            }
            return newArray;
        };
        // Apply function
        inputArr = reverseArray.apply(inputArr);
        // Create special function -> Consumer
        Consumer<int[]> printNumbers = numbers -> {
            for (int number: numbers) {
                System.out.print(number + " ");
            }
        };
        // Apply special function -> Consumer
        printNumbers.accept(inputArr);
    }

    private static int[] readArray(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
