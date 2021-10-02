package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> playerValueMap = new LinkedHashMap<>();
        Map<String, Set<String>> cardsMap = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String playerName = tokens[0];
            int value = calculateValue(cardsMap, playerName, tokens[1]);
            updateMap(playerValueMap, playerName, value);
            input = scan.nextLine();
        }

        printMap(playerValueMap);
    }

    private static void printMap(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static void updateMap(Map<String, Integer> map, String playerName, int value) {
        if (map.containsKey(playerName)) {
            int currValue = map.get(playerName);
            map.replace(playerName, currValue + value);
        } else {
            map.put(playerName, value);
        }
    }

    private static int calculateValue(Map<String, Set<String>> cardsMap,String playerName, String tokens) {
        String[] cards = tokens.split(",\\s+");
        Set<String> set = new LinkedHashSet<>();
        if (cardsMap.containsKey(playerName)) {
            for (int i = 0; i < cards.length; i++) {
                if (!cardsMap.get(playerName).contains(cards[i])) {
                    set.add(cards[i]);
                    cardsMap.get(playerName).add(cards[i]);
                }
            }
        } else {
            for (int i = 0; i < cards.length; i++) {
                set.add(cards[i]);
            }
            cardsMap.put(playerName, set);
        }
        int value = 0;
        for (String card : set) {
            int nextCardValue = calculateCardValue(card);
            value += nextCardValue;
        }
        return value;
    }

    private static int calculateCardValue(String card) {
        // Determine power
        int power = 0;
        if (Character.isDigit(card.charAt(0)) && Character.isDigit(card.charAt(1))) {
            String substring = card.substring(0, card.length() - 1);
            power = Integer.parseInt(substring);
        } else if (Character.isDigit(card.charAt(0)) && !Character.isDigit(card.charAt(1))) {
            power = Character.getNumericValue(card.charAt(0));
        } else {
            switch (card.charAt(0)) {
                case 'J':
                    power = 11;
                    break;
                case 'Q':
                    power = 12;
                    break;
                case 'K':
                    power = 13;
                    break;
                case 'A':
                    power = 14;
                    break;
            }
        }
        // Determine type
        int type = 0;
        switch (card.charAt(card.length() - 1)) {
            case 'S':
                type = 4;
                break;
            case 'H':
                type = 3;
                break;
            case 'D':
                type = 2;
                break;
            case 'C':
                type = 1;
                break;
        }
        return power * type;
    }
}
