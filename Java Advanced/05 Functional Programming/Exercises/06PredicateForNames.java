package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");
        // Create special function -> Predicate
        Predicate<String> validName = name -> {
            if (name.length() <= n) {
                return true;
            }
            return false;
        };
        // Apply Predicate
        List<String> list = new ArrayList<>();
        for (String name : names) {
            if (validName.test(name)) {
                list.add(name);
            }
        }
        // Create new array
        names = listToArray(list);
        // Create special function -> Consumer
        Consumer<String[]> printNames = strings -> {
            for (String string: strings) {
                System.out.println(string);
            }
        };
        // Apply Consumer
        printNames.accept(names);
    }

    private static String[] listToArray(List<String> list) {
        String[] newArr = new String[list.size()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = list.get(i);
        }
        return newArr;
    }
}
