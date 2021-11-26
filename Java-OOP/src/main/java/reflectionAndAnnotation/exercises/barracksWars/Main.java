package reflectionAndAnnotation.exercises.barracksWars;

import reflectionAndAnnotation.exercises.barracksWars.interfaces.Repository;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.Runnable;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.UnitFactory;
import reflectionAndAnnotation.exercises.barracksWars.core.Engine;
import reflectionAndAnnotation.exercises.barracksWars.core.factories.UnitFactoryImpl;
import reflectionAndAnnotation.exercises.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
