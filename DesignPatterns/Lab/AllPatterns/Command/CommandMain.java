package DesignPatterns.Lab.AllPatterns.Command;

import java.util.List;

public class CommandMain {
    public static void main(String[] args) {

        Command.Lamp lampKitchen = new Command.Lamp();
        Command.Lamp lampLivingRoom = new Command.Lamp();
        Command.Lamp lampBedroom = new Command.Lamp();

        TurnAllLightsOn allLightsOn = new TurnAllLightsOn(List.of(lampKitchen, lampLivingRoom, lampBedroom));

        Switch invoker = new Switch();

        invoker.storeAndExecute(new LightOn(lampKitchen));
        invoker.storeAndExecute(new LightOff(lampKitchen));

        invoker.storeAndExecute(allLightsOn);
    }
}
