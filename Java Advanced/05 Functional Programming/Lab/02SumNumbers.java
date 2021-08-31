package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> sum = x -> Arrays.stream(x).sum();
        Function<int[], Long> count = x -> Arrays.stream(x).count();

        System.out.println("Count = " + count.apply(input));
        System.out.println("Sum = " + sum.apply(input));
    }
}
