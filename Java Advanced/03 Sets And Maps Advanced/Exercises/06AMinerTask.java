package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scan.nextLine());;
            updateMap(resource, quantity, map);
            input = scan.nextLine();
        }
        printMap(map);
    }

    private static void printMap(Map<String, Integer> map) {
        map.entrySet().stream()
                .forEach(e -> System.out.printf("%s -> %d%n", e.getKey(), e.getValue()));
    }

    private static void updateMap(String resource, int quantity, Map<String, Integer> map) {
        if (map.containsKey(resource)) {
            int currQuantity = map.get(resource);
            map.replace(resource, currQuantity + quantity);
        } else {
            map.put(resource, quantity);
        }
    }
}
