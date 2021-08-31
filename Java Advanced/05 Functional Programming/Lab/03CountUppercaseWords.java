package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Predicate<String> isUpperCase = x -> Character.isUpperCase(x.charAt(0));

        String[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(isUpperCase).toArray(String[]::new);


        System.out.println(input.length);
        Arrays.stream(input).forEach(System.out::println);
    }
}
