package DesignPatterns.Exercise.Command;

public class VolumeDown implements Command {
    Radio radio;

    public VolumeDown(Radio radio) {
        this.radio = radio;
    }

    @Override
    public void execute() {
        this.radio.volumeDown();
    }
}
