package DesignPatterns.Lab.AllPatterns.Command;

public class LightOn implements Command.Command {
    private Command.Lamp lamp;

    public LightOn(Command.Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.on();
    }
}
