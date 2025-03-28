package Polymorphism.Exercise.vehicles;

public class Truck extends Vehicle {

    public static final double AIR_CONDITIONER_CONSUMPTION = 1.6;
    public static final double TINY_HOLE_IN_TANK = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tank) {
        super(fuelQuantity, fuelConsumption, tank);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters * TINY_HOLE_IN_TANK);
    }

}
