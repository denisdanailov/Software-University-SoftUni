package exams.javaOopExamApril2021.problem1.aquarium.entities.decorations;

public class Ornament extends BaseDecoration{
    private final static int ORNAMENT_COMFORT = 1;
    private final static double ORNAMENT_PRICE = 5;

    public Ornament() {
        super(ORNAMENT_COMFORT, ORNAMENT_PRICE);
    }
}
