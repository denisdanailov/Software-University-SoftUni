package reflectionAndAnnotation.exercises.barracksWars.core.commands;

import reflectionAndAnnotation.exercises.barracksWars.interfaces.Executable;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.Repository;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command (String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    protected String[] getData() {
        return data;
    }
}
