package DesignPatterns.Exercise.Command;

public class VolumeUp implements Command {
    Radio radio;

    public VolumeUp(Radio radio) {
        this.radio = radio;
    }

    @Override
    public void execute() {
        this.radio.volumeUp();
    }
}
