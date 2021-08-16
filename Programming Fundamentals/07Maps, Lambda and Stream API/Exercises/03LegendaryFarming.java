package AssociativeArrays.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isObtained = false;
        int counter = 0;
        String material = "";
        int quantity = 0;

        Map<String, Integer> legendaryItem = new HashMap<>();
        legendaryItem.put("fragments", 0);
        legendaryItem.put("shards", 0);
        legendaryItem.put("motes", 0);
        Map<String, Integer> junkItem = new TreeMap<>();

        while (!isObtained) {
        String input = scan.next().toLowerCase();
        counter++;

        if (counter % 2 != 0) {
        quantity = Integer.parseInt(input);
        } else {
            material = input;
            if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                if (legendaryItem.containsKey(material)) {
                    int currQuant = legendaryItem.get(material);
                    legendaryItem.replace(material, currQuant + quantity);
                } else {
                    legendaryItem.put(material, quantity);
                }

                String output = "";
                if (legendaryItem.get(material) >= 250) {
                    isObtained = true;
                    switch (material) {
                        case "shards":
                            output = "Shadowmourne";
                            break;
                        case "fragments":
                            output = "Valanyr";
                            break;
                        case "motes":
                            output = "Dragonwrath";
                            break;
                    }
                    System.out.printf("%s obtained!%n", output);
                    int currQuant = legendaryItem.get(material);
                    legendaryItem.replace(material, currQuant - 250);
                }
            } else {
                if (junkItem.containsKey(material)) {
                    int currQuant = junkItem.get(material);
                    junkItem.replace(material, currQuant + quantity);
                } else {
                    junkItem.put(material, quantity);
                }
            }
        }
        }

        legendaryItem.entrySet()
                .stream()
                .sorted((a,b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(dataSet -> System.out.println(dataSet.getKey() + ": " + dataSet.getValue()));

        junkItem.entrySet()
                .stream()
                .forEach(dataSet -> System.out.println(dataSet.getKey() + ": " + dataSet.getValue()));
    }
}
