package exams.finalExamOopDecember2021.problem1.catHouse.entities.houses;

import exams.finalExamOopDecember2021.problem1.catHouse.entities.cat.Cat;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
