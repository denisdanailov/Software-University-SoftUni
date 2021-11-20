package reflectionAndAnnotation.exercises.barracksWars.core.commands;

import reflectionAndAnnotation.exercises.barracksWars.interfaces.Repository;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command{

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
