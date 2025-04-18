package ReflectionAndAnnotation.Exercise.barracksWars.core.commands;


import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;

public class Report extends Command {

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();
    }
}
