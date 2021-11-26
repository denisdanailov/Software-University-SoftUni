package reflectionAndAnnotation.exercises.barracksWars.core.factories;

import reflectionAndAnnotation.exercises.barracksWars.interfaces.Unit;
import reflectionAndAnnotation.exercises.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflectionAndAnnotation.exercises.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> declaredConstructor = clazz.getDeclaredConstructor();
			return declaredConstructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
