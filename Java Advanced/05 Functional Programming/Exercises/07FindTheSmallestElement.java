package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] inputArr = readArray(scan, "\\s+");
        // Create custom Function smallest element
        Function<int[], Integer> smallestElementFunc = names -> {
            int index = -1;
            int minValue =Integer.MAX_VALUE;
            for (int i = 0; i < names.length; i++) {
                if (minValue >= names[i]) {
                    minValue = names[i];
                    index = i;
                }
            }
            return index;
        };

        if (smallestElementFunc.apply(inputArr) != -1) {
            System.out.println(smallestElementFunc.apply(inputArr));
        }
    }

    private static int[] readArray(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
