package polymorphism.exercises.wildFarm.animals;

import polymorphism.exercises.wildFarm.abstractClasses.Food;
import polymorphism.exercises.wildFarm.abstractClasses.Mammal;
import polymorphism.exercises.wildFarm.food.Meat;
import polymorphism.exercises.wildFarm.food.Vegetable;

import java.text.DecimalFormat;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Zebras are not eating that type of food!");
        } else if (food instanceof Vegetable) {
            Integer currFood = super.getFoodEaten();
            super.setFoodEaten(currFood + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                formatter.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
