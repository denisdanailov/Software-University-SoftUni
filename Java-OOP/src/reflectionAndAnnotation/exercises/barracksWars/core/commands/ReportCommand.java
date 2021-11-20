package reflectionAndAnnotation.exercises.barracksWars.core.commands;

import reflectionAndAnnotation.exercises.barracksWars.interfaces.Repository;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command{

    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = getRepository().getStatistics();
        return output;
    }
}
