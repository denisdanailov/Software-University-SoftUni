package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read input Array
        int[] inputArr = readInput(scan,"\\s+");
        // Create Function
        Function<int[], Integer> minFunc = numArray -> {
            int minNum = Integer.MAX_VALUE;
            for (int num: numArray) {
               if (num < minNum) {
                   minNum = num;
               }
            }
            return  minNum;
        };
        // Print Function output
        System.out.println(minFunc.apply(inputArr));
    }

    private static int[] readInput(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
