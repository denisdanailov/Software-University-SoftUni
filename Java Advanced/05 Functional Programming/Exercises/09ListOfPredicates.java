package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        // Read Input
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] inputArr = readArray(scan, "\\s+");
        // Create Predicate List
        List<Predicate<Integer>> predicateList = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            int index = i;
            Predicate<Integer> newPredicate = number -> number % inputArr[index] == 0;
            predicateList.add(newPredicate);
        }
        // Logic
        for (int i = 1; i <= n; i++) {
            boolean isDivisible = true;
            for (int j = 0; j < predicateList.size(); j++) {
                if (!predicateList.get(j).test(i)) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                System.out.print(i + " ");
            }
        }
    }

    private static int[] readArray(Scanner scan, String delimiter) {
        return Arrays.stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt).toArray();
    }
}
