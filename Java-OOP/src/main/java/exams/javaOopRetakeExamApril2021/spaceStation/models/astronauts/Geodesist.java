package exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{
    private final static double INITIAL_UNITS_OXYGEN = 50;

    public Geodesist(String name) {
        super(name, INITIAL_UNITS_OXYGEN);
    }
}
