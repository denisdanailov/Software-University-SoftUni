package polymorphism.exercises.wildFarm;

import polymorphism.exercises.wildFarm.abstractClasses.Animal;
import polymorphism.exercises.wildFarm.abstractClasses.Food;
import polymorphism.exercises.wildFarm.animals.Cat;
import polymorphism.exercises.wildFarm.animals.Mouse;
import polymorphism.exercises.wildFarm.animals.Tiger;
import polymorphism.exercises.wildFarm.animals.Zebra;
import polymorphism.exercises.wildFarm.food.Meat;
import polymorphism.exercises.wildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();

        int counter = -1;

        String input = scan.nextLine();

        while (!input.equals("End")) {
            counter++;

            if (counter % 2 == 0) {
                String[] tokens = input.split("\\s+");

                Animal animal = createAnimal(tokens);
                animalList.add(animal);
                animal.makeSound();
            } else {
                String[] tokens = input.split("\\s+");

                Food food = createFood(tokens);

                Animal animal = animalList.get(animalList.size() - 1);
                animal.eat(food);
            }

            input = scan.nextLine();
        }

        animalList.forEach(System.out::println);
    }

    private static Food createFood(String[] tokens) {
        String foodType = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        switch (foodType) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
            default:
                return null;
        }
    }

    private static Animal createAnimal(String[] tokens) {
        String animalType = tokens[0];
        String name = tokens[1];
        Double weight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        switch (animalType) {
            case "Cat":
                String breed = tokens[4];
                return new Cat(name, animalType, weight, livingRegion, breed);
            case "Mouse":
                return new Mouse(name, animalType, weight, livingRegion);
            case "Zebra":
                return new Zebra(name, animalType, weight, livingRegion);
            case "Tiger":
                return new Tiger(name, animalType, weight, livingRegion);
            default:
                return null;
        }
    }
}
