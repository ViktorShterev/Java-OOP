package ReflectionAndAnnotation.Exercise.barracksWars.core.commands;


import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
