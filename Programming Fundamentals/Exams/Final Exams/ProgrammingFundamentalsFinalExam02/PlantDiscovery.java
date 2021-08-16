package Exams.FinalExams.ProgrammingFundamentalsFinalExam02;

import java.util.*;

public class PlantDiscovery {

    public static class Plant {
    String plantName = "";
    int rarity = 0;
    List<Double> ratingsList = new ArrayList<>();
    double avgRating = 0;
    public Plant(String plantName, int rarity) {
        this.plantName = plantName;
        this.rarity = rarity;
    }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Plant> plantMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("<->");
            String plantName = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            if (!plantMap.containsKey(plantName)) {
                Plant newPlant = new Plant(plantName, rarity);
                plantMap.put(plantName, newPlant);
            } else {
                //Update rarity не е ясно дали да подменим стойността или да добавим
                plantMap.get(plantName).rarity = rarity;
            }
        }

        String input = scan.nextLine();
        while(!input.equals("Exhibition")) {
            String[] tokens = input.split(": | - | – ");
            String action = tokens[0];
            String plant = tokens[1];
            switch (action) {
                case "Rate":
                    double rating = Double.parseDouble(tokens[2]);
                    if (plantMap.containsKey(plant)) {
                        plantMap.get(plant).ratingsList.add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(tokens[2]);
                    if (plantMap.containsKey(plant)) {
                        plantMap.get(plant).rarity = newRarity;
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plantMap.containsKey(plant)) {
                        plantMap.get(plant).ratingsList.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (Map.Entry<String, Plant> entry : plantMap.entrySet()) {
            double sum = 0;
            for (int i = 0; i < entry.getValue().ratingsList.size(); i++) {
                sum += entry.getValue().ratingsList.get(i);
            }
            entry.getValue().avgRating = sum / entry.getValue().ratingsList.size();
        }

        System.out.println("Plants for the exhibition:");

        plantMap.entrySet().stream()
                .sorted((a,b) -> {
                    if (a.getValue().rarity == b.getValue().rarity) {
                      return Double.compare(b.getValue().avgRating, a.getValue().avgRating);
                    } else {
                        return Integer.compare(b.getValue().rarity, a.getValue().rarity);
                    }
                })
                .forEach(entry -> {
                    if (entry.getValue().ratingsList.size() > 0) {
                        System.out.printf("- %s; Rarity: %d; Rating: %.02f%n", entry.getValue().plantName, entry.getValue().rarity, entry.getValue().avgRating);
                    } else {
                        System.out.printf("- %s; Rarity: %d; Rating: %.02f%n", entry.getValue().plantName, entry.getValue().rarity, 0.00);
                    }
                });
    }
}
