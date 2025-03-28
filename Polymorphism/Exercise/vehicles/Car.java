package Polymorphism.Exercise.vehicles;

public class Car extends Vehicle {

    public static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tank) {
        super(fuelQuantity, fuelConsumption, tank);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

}
