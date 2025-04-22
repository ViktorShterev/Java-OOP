package DesignPatterns.Lab.AllPatterns.Command;

public class LightOff implements Command.Command {
    private Command.Lamp lamp;

    public LightOff(Command.Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.off();
    }
}
