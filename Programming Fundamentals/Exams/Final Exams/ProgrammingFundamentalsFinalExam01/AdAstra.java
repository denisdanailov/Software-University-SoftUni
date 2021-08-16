package Exams.FinalExams.ProgrammingFundamentalsFinalExam01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {

    public static class Item {
        String name;
        String expDate;
        int calories;

        public Item(String name, String expDate, int calories) {
            this.name = name;
            this.expDate = expDate;
            this.calories = calories;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Pattern regex = Pattern.compile("(\\||#)(?<name>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = regex.matcher(input);

        int sumCalories = 0;

        Map<Integer, Item> itemMap = new LinkedHashMap<>();
        int index = 0;
        while (matcher.find()) {
            String itemName = matcher.group("name");
            String expDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));
            if (isCaloriesValid(calories) && isDateValid(expDate)) {
                Item newItem = new Item(itemName, expDate, calories);
                itemMap.put(index, newItem);
                index += 1;
            }
            sumCalories += calories;
        }
        int daysWithFood = sumCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", daysWithFood);

        itemMap.entrySet().stream().forEach(entrySet -> System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", entrySet.getValue().name, entrySet.getValue().expDate, entrySet.getValue().calories));
    }

    public static boolean isCaloriesValid (int calories) {
        if (calories >= 0 && calories <= 10000) {
            return true;
        }
        return false;
    }

    public static boolean isDateValid (String date) {
        Pattern regex = Pattern.compile("(?<day>\\d{2})\\/(?<month>\\d{2})\\/(?<year>\\d{2})");
        Matcher matcher = regex.matcher(date);
        while (matcher.find()) {
            int day = Integer.parseInt(matcher.group("day"));
            int month = Integer.parseInt(matcher.group("month"));
            int year = Integer.parseInt(matcher.group("year"));
            if (day <= 31 && month <= 12) {
                return true;
            }
        }
        return false;
    }
}
