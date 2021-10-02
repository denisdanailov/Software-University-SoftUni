package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        fillSet(set, n, scan);

        printSet(set);

    }

    private static void printSet(LinkedHashSet<String> set) {
        for (String output : set) {
            System.out.println(output);
        }
    }

    private static void fillSet(LinkedHashSet<String> set,int n, Scanner scan) {
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            set.add(input);
        }
    }
}
