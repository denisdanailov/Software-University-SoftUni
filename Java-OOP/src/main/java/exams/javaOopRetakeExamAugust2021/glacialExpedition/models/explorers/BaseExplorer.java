package exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.common.ExceptionMessages;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.suitcases.Carton;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.suitcases.Suitcase;

import java.util.ArrayList;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        if (this.energy - 15 <= 0) {
            this.energy = 0;
        } else {
            energy -= 15;
        }
    }
}
