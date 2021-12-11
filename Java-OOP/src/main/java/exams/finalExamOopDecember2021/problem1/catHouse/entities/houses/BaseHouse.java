package exams.finalExamOopDecember2021.problem1.catHouse.entities.houses;

import exams.finalExamOopDecember2021.problem1.catHouse.common.ConstantMessages;
import exams.finalExamOopDecember2021.problem1.catHouse.common.ExceptionMessages;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.cat.Cat;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sumSoftness = toys.stream().mapToInt(Toy::getSoftness).sum();
        return sumSoftness;
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append(String.format("%s %s:",this.name, this.getClass().getSimpleName())).append(System.lineSeparator());

        if (this.cats.isEmpty()) {
            strBuild.append("Cats: none").append(System.lineSeparator());
        } else {
            List<String> catNames = this.cats.stream().map(Cat::getName).collect(Collectors.toList());
            strBuild.append(String.format("Cats: %s",String.join(" ", catNames))).append(System.lineSeparator());
        }

        long countToys = this.toys.stream().count();
        strBuild.append(String.format("Toys: %d Softness: %d",countToys, this.sumSoftness())).append(System.lineSeparator());

        return strBuild.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
