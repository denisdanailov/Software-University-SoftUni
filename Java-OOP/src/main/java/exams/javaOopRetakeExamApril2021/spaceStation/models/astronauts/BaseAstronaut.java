package exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts;

import exams.javaOopRetakeExamApril2021.spaceStation.common.ExceptionMessages;
import exams.javaOopRetakeExamApril2021.spaceStation.models.bags.Backpack;
import exams.javaOopRetakeExamApril2021.spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        if (oxygen <= 10) {
            oxygen = 0;
        } else {
            oxygen -= 10;
        }
    }
}
