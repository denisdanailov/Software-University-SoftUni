package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                int currCount = map.get(c);
                map.replace(c, currCount + 1);
            } else {
                map.put(c, 1);
            }
        }

        printMap(map);
    }

    private static void printMap(Map<Character, Integer> map) {
        map.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(entry -> System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue()));

    }
}
