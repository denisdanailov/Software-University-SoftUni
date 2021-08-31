package FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] inputs = scan.nextLine().split(",\\s+");
            String name = inputs[0];
            int age = Integer.parseInt(inputs[1]);
            map.put(name, age);
        }

        String olderOrYounger = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Map.Entry<String, Integer>> isOlderOrYounger = getAgeFilter(olderOrYounger, age);

        Consumer<Map.Entry<String, Integer>> printAndFormatting = getPrintConsumer(format);

        map.entrySet().stream()
                .filter(isOlderOrYounger::test)
                .forEach(printAndFormatting::accept);
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        if (format.equals("name")) {
            return entry -> System.out.println(entry.getKey());
        } else if (format.equals("age")) {
            return entry -> System.out.println(entry.getValue());
        } else {
            return entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(String olderOrYounger, int age) {
        if (olderOrYounger.equals("older")) {
            return entry -> entry.getValue() >= age;
        }
        return entry -> entry.getValue() <= age;
    }
}
