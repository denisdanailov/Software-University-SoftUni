package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        // Read the names
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        // Read the commands
        String input = scan.nextLine();
        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];
            String condition = tokens[1];
            String criteria = tokens[2];
            int subSize = 0;
            switch (action) {
                case "Remove":
                    List<Integer> toRemove = new ArrayList<>();
                    switch (condition) {
                        case "StartsWith":
                            subSize = criteria.length();
                            toRemove = fillListStartsWithToRemove(names, subSize, criteria);
                            executeList(toRemove, names);
                            break;
                        case "EndsWith":
                            subSize = criteria.length();
                            toRemove = fillListEndsWithToRemove(names, subSize, criteria);
                            executeList(toRemove, names);
                            break;
                        case "Length":
                            int length = Integer.parseInt(criteria);
                            toRemove = fillListLengthToRemove(names, length);
                            executeList(toRemove, names);
                            break;
                    }
                    break;
                case "Double":
                    Map<Integer, String> toDouble = new LinkedHashMap<>();
                    switch (condition) {
                        case "StartsWith":
                            subSize = criteria.length();
                            toDouble = fillMapStartsWithToDouble(names, subSize, criteria);
                            executeMap(toDouble, names);
                            break;
                        case "EndsWith":
                            subSize = criteria.length();
                            toDouble = fillMapEndsWithToDouble(names, subSize, criteria);
                            executeMap(toDouble, names);
                            break;
                        case "Length":
                            int length = Integer.parseInt(criteria);
                            toDouble = fillMapLengthToDouble(names, length);
                            executeMap(toDouble, names);
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        // Print
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(printNames(names) + "are going to the party!");
        }
    }

    private static String printNames(List<String> names) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i != names.size() - 1) {
                output.append(names.get(i)).append(", ");
            } else {
                output.append(names.get(i)).append(" ");
            }
        }
        return output.toString();
    }

    private static void executeList(List<Integer> toRemove, List<String> names) {
        for (int index : toRemove) {
            names.remove(index);
        }
    }

    private static void executeMap(Map<Integer, String> toDouble, List<String> names) {
        for (Map.Entry<Integer, String> entry : toDouble.entrySet()) {
            names.add(entry.getKey(), entry.getValue());
        }
    }

    private static Map<Integer, String> fillMapLengthToDouble(List<String> names, int length) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() == length) {
                map.put(i, name);
            }
        }
        return map;
    }

    private static Map<Integer, String> fillMapEndsWithToDouble(List<String> names, int subSize, String criteria) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() >= subSize) {
                String substring = name.substring(name.length() - subSize);
                if (criteria.equals(substring)) {
                    map.put(i, name);
                }
            }
        }
        return map;
    }

    private static Map<Integer, String> fillMapStartsWithToDouble(List<String> names, int subSize, String criteria) {
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() > subSize) {
                String substring = name.substring(0, subSize);
                if (criteria.equals(substring)) {
                    map.put(i, name);
                }
            }
        }
        return map;
    }

    private static List<Integer> fillListLengthToRemove(List<String> names, int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() == length) {
                list.add(i);
            }
        }
        return list;
    }

    private static List<Integer> fillListEndsWithToRemove(List<String> names, int subSize, String criteria) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() >= subSize) {
                String substring = name.substring(name.length() - subSize);
                if (criteria.equals(substring)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    private static List<Integer> fillListStartsWithToRemove(List<String> names, int subSize, String criteria) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.length() > subSize) {
                String substring = name.substring(0, subSize);
                if (criteria.equals(substring)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
