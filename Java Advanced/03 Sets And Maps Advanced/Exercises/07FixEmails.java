package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, String> map = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String name = input;
            String email = scan.nextLine();
            updateMap(map, name, email);
            input = scan.nextLine();
        }

        printMap(map);
    }

    private static void printMap(Map<String, String> map) {
        map.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }

    private static void updateMap(Map<String, String> map, String name, String email) {
        if (map.containsKey(name)) {
            if (checkIsValidEmail(email)) {
                map.replace(name, email);
            }
        } else {
            if (checkIsValidEmail(email)) {
                map.put(name, email);
            }
        }
    }

    private static boolean checkIsValidEmail(String email) {
        int beginIndex = 0;
        for (int i = email.length() - 1; i >= 0; i--) {
            if (email.charAt(i) == '.') {
             beginIndex = i;
             break;
            }
        }
        String substring = email.substring(beginIndex + 1);
        if (substring.equals("us") || substring.equals("uk") || substring.equals("com")) {
            return false;
        }
        return true;
    }
}
