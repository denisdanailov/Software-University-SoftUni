package exams.javaOopExamApril2021.problem1.aquarium.entities.decorations;

public class Plant extends BaseDecoration{
    private final static int PLANT_COMFORT = 5;
    private final static double PLANT_PRICE = 10;

    public Plant() {
        super(PLANT_COMFORT, PLANT_PRICE);
    }
}
