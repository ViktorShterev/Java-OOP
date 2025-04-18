package ReflectionAndAnnotation.Exercise.barracksWars.core.factories;

import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"src.main.java.ReflectionAndAnnotation.Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3

		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);

			Constructor<Unit> unitConstructor = unitClass.getDeclaredConstructor();

			return unitConstructor.newInstance();

		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
				 InvocationTargetException e) {
			return null;
		}

	}
}
