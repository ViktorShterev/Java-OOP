package Command;

import java.util.List;

public class CommandMain {
    public static void main(String[] args) {

        Lamp lampKitchen = new Lamp();
        Lamp lampLivingRoom = new Lamp();
        Lamp lampBedroom = new Lamp();

        TurnAllLightsOn allLightsOn = new TurnAllLightsOn(List.of(lampKitchen, lampLivingRoom, lampBedroom));

        Switch invoker = new Switch();

        invoker.storeAndExecute(new LightOn(lampKitchen));
        invoker.storeAndExecute(new LightOff(lampKitchen));

        invoker.storeAndExecute(allLightsOn);
    }
}
