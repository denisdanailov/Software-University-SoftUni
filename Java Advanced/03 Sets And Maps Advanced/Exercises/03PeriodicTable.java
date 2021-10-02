package SetsAndMapsAdvanced.Exercises;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        // Reading Input
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        // Creating Set
        TreeSet<String> set = createSet(n, scan);
        // Print
        printSet(set);
    }

    private static void printSet(TreeSet<String> set) {
        for (String element : set) {
            System.out.print(element + " ");
        }

    }

    private static TreeSet<String> createSet(int n, Scanner scan) {
        TreeSet<String> set = new TreeSet<>();
        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                set.add(input[i]);
            }
        }
        return set;
    }
}
