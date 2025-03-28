package Polymorphism.Exercise.vehicles;

public class Bus extends Vehicle {

    private static final double  AIR_CONDITIONER_CONSUMPTION = 1.4;

    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tank) {
        super(fuelQuantity, fuelConsumption, tank);
        isEmpty = true;
    }


    public void setEmpty(boolean empty) {
        if (this.isEmpty == empty) {
            return;
        }
        if (this.isEmpty && !empty) {
            super.setFuelConsumption(super.getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION);
        }
        if (!this.isEmpty && empty) {
            super.setFuelConsumption(super.getFuelConsumption() - AIR_CONDITIONER_CONSUMPTION);
        }
        this.isEmpty = empty;
    }
}
