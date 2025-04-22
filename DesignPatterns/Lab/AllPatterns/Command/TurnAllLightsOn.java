package DesignPatterns.Lab.AllPatterns.Command;

import java.util.List;

public class TurnAllLightsOn implements Command.Command {
    private List<Command.Lamp> lamps;

    public TurnAllLightsOn(List<Command.Lamp> lamps) {
        this.lamps = lamps;
    }

    @Override
    public void execute() {
        for (Command.Lamp lamp : lamps) {
            lamp.on();
        }
    }
}
