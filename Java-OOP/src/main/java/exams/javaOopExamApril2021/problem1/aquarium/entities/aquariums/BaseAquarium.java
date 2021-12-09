package exams.javaOopExamApril2021.problem1.aquarium.entities.aquariums;

import exams.javaOopExamApril2021.problem1.aquarium.common.ConstantMessages;
import exams.javaOopExamApril2021.problem1.aquarium.common.ExceptionMessages;
import exams.javaOopExamApril2021.problem1.aquarium.entities.decorations.Decoration;
import exams.javaOopExamApril2021.problem1.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        int sumComfort = decorations.stream().mapToInt(Decoration::getComfort).sum();
        return sumComfort;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() < this.capacity) {
            this.fish.add(fish);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append(String.format("%s (%s):",this.name, getClass().getSimpleName())).append(System.lineSeparator());

        String fishStrings = this.fish.stream().map(Fish::getName).collect(Collectors.joining(" "));

        if (fishStrings.trim().isEmpty()) {
            strBuild.append("Fish: none").append(System.lineSeparator());
        } else {
            strBuild.append(String.format("Fish: %s", fishStrings)).append(System.lineSeparator());
        }

        int decorationsCount = this.decorations.size();
        strBuild.append(String.format("Decorations: %d", decorationsCount)).append(System.lineSeparator());

        int comfortSum = this.decorations.stream().mapToInt(Decoration::getComfort).sum();
        strBuild.append(String.format("Comfort: %d", comfortSum));

        return strBuild.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
