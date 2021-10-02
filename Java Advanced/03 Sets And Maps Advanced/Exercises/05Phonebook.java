package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nextLine = scan.nextLine();
        Map<String, String> map = new LinkedHashMap<>();
        while (!nextLine.equals("search")) {
            String[] tokens = nextLine.split("-");
            String name = tokens[0];
            String phoneNum = tokens[1];
            updateMap(map, name, phoneNum);
            nextLine = scan.nextLine();
        }
        nextLine = scan.nextLine();
        while (!nextLine.equals("stop")) {
            printMessage(map, nextLine);
            nextLine = scan.nextLine();
        }
    }

    private static void printMessage(Map<String, String> map, String input) {
        if (map.containsKey(input)) {
            System.out.printf("%s -> %s%n", input, map.get(input));
        } else {
            System.out.printf("Contact %s does not exist.%n", input);
        }
    }

    private static void updateMap(Map<String, String> map, String name, String phoneNum) {
        if (map.containsKey(name)) {
            map.replace(name, phoneNum);
        } else {
            map.put(name, phoneNum);
        }
    }
}
