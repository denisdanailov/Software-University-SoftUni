package exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private final static double INITIAL_UNITS_OXYGEN = 70;

    public Biologist(String name) {
        super(name,INITIAL_UNITS_OXYGEN);
    }

    @Override
    public void breath() {
        double currOxygen = super.getOxygen();
        if (currOxygen <= 5) {
            super.setOxygen(0);
        } else {
            super.setOxygen(currOxygen - 5);
        }
    }
}
