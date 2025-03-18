package InterfacesAndAbstraction.Lab.ferrari;

public class Ferrari implements Car {

    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = Car.MODEL;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", Car.MODEL, this.brakes(), this.gas(), this.driverName);
    }
}
