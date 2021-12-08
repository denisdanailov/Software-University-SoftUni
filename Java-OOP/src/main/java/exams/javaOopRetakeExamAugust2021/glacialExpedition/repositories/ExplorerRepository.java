package exams.javaOopRetakeExamAugust2021.glacialExpedition.repositories;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExplorerRepository implements Repository<Explorer> {
    private List<Explorer> explorers;

    public ExplorerRepository() {
        explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableList(explorers);
    }

    @Override
    public void add(Explorer entity) {
        explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        for (Explorer explorer : explorers) {
            if (explorer.getName().equals(name)) {
                return explorer;
            }
        }
        return null;
    }
}
