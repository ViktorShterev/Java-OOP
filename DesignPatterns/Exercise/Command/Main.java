package DesignPatterns.Exercise.Command;

public class Main {
    public static void main(String[] args) {

        Radio radio = new Radio();
        Controller controller = new Controller();

        controller.executeCommand(new VolumeUp(radio));

    }
}
