package exams.javaOopExamApril2021.problem1.aquarium.repositories;

import exams.javaOopExamApril2021.problem1.aquarium.entities.decorations.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
