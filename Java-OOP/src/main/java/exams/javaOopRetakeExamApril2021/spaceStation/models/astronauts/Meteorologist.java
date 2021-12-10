package exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut{
    private final static double INITIAL_UNITS_OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, INITIAL_UNITS_OXYGEN);
    }
}
