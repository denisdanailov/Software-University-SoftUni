package polymorphism.exercises.wildFarm.animals;

import polymorphism.exercises.wildFarm.abstractClasses.Felime;
import polymorphism.exercises.wildFarm.abstractClasses.Food;
import polymorphism.exercises.wildFarm.food.Meat;
import polymorphism.exercises.wildFarm.food.Vegetable;

import java.text.DecimalFormat;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            System.out.println("Tigers are not eating that type of food!");
        } else if (food instanceof Meat) {
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
