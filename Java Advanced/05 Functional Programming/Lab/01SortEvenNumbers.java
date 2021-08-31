package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        String outputWithoutOrder = Arrays.stream(input)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        String outputWithOrder = Arrays.stream(input)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(outputWithoutOrder);
        System.out.println(outputWithOrder);

    }
}
