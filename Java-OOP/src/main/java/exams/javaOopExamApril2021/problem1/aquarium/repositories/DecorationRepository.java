package exams.javaOopExamApril2021.problem1.aquarium.repositories;

import exams.javaOopExamApril2021.problem1.aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository{
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return this.decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        for (Decoration decoration : this.decorations) {
            String decorationType = decoration.getClass().getSimpleName();
            if (decorationType .equals(type)) {
                return decoration;
            }
        }
        return null;
    }
}
