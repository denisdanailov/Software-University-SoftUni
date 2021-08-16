package Exams.FinalExams.FinalExam;

import java.util.*;

public class Problem03 {

    public static class Animal {
    String name;
    int neededFood;
    String area;
    public Animal(String name, int food, String area) {
        this.name = name;
        this.neededFood = food;
        this.area = area;
    }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Animal> animalMap = new LinkedHashMap<>();
        while (!input.equals("EndDay")) {
            String[] tokens = input.split(":\\s+");
            String action = tokens[0];
            String[] items = tokens[1].split("\\s*-\\s*");
            String animalName = items[0];
            switch (action) {
                case "Add":
                    int neededFood = Integer.parseInt(items[1]);
                    String area = items[2];
                    if (!animalMap.containsKey(animalName)) {
                        Animal newAnimal = new Animal(animalName, neededFood, area);
                        animalMap.put(animalName, newAnimal);
                    } else {
                        animalMap.get(animalName).neededFood += neededFood;
                    }
                    break;
                case "Feed":
                    int food = Integer.parseInt(items[1]);
                    if (animalMap.containsKey(animalName)) {
                        animalMap.get(animalName).neededFood -= food;
                        if (animalMap.get(animalName).neededFood <= 0) {
                            System.out.printf("%s was successfully fed%n", animalName);
                            animalMap.remove(animalName);
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }

        Map<String, List<String>> hungryAnimalsByArea = new LinkedHashMap<>();
        animalMap.entrySet().stream().forEach(entrySet -> {
            if (entrySet.getValue().neededFood > 0) {
                String name = entrySet.getValue().name;
                String area = entrySet.getValue().area;
                if (!hungryAnimalsByArea.containsKey(area)) {
                    List<String> newList = new ArrayList<>();
                    newList.add(name);
                    hungryAnimalsByArea.put(area, newList);
                } else {
                    hungryAnimalsByArea.get(area).add(name);
                }
            }
        });
        //Сортировка по останали животни
        System.out.println("Animals:");
        animalMap.entrySet().stream()
                .sorted((a,b) -> {
                    if (a.getValue().neededFood == b.getValue().neededFood) {
                      return a.getValue().name.compareTo(b.getValue().name);
                    }
                    return Integer.compare(b.getValue().neededFood, a.getValue().neededFood); })
                . forEach(entrySet -> {
                    System.out.printf("%s -> %dg%n", entrySet.getValue().name, entrySet.getValue().neededFood); });

        //Сортировка по гладни животни и райони
        System.out.println("Areas with hungry animals:");
        hungryAnimalsByArea.entrySet().stream()
                .sorted((a,b) -> {
                    if (a.getValue().size()==b.getValue().size()) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return Integer.compare(b.getValue().size(), a.getValue().size()); })
                .forEach(entrySet -> {
                    System.out.printf("%s: %d%n", entrySet.getKey(), entrySet.getValue().size()); });
    }
}
