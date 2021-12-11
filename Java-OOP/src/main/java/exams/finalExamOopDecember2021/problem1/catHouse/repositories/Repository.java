package exams.finalExamOopDecember2021.problem1.catHouse.repositories;

import exams.finalExamOopDecember2021.problem1.catHouse.entities.toys.Toy;

public interface Repository {

    void buyToy(Toy toy);

    boolean removeToy(Toy toy);

    Toy findFirst(String type);
}
