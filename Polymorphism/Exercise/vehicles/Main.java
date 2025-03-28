package Polymorphism.Exercise.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Vehicle car = getVehicle(input);

        String[] truckInput = scanner.nextLine().split("\\s+");
        Vehicle truck = getVehicle(truckInput);

        String[] busInput = scanner.nextLine().split("\\s+");
        Vehicle bus = getVehicle(busInput);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String command = scanner.nextLine();

            String[] tokens = command.split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];
            double amount = Double.parseDouble(tokens[2]);

            Vehicle vehicle = vehicles.get(vehicleType);

            switch (commandName) {
                case "Drive":
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(false);
                    }
                    System.out.println(vehicle.drive(amount));
                    break;
                case "Refuel":
                    try {
                        vehicle.refuel(amount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(true);
                    }
                    System.out.println(vehicle.drive(amount));
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(String[] input) {
        String type = input[0];
        double fuel = Double.parseDouble(input[1]);
        double consumption = Double.parseDouble(input[2]);
        double tank = Double.parseDouble(input[3]);

        Vehicle vehicle = null;

        switch (type) {
            case "Car":
                vehicle = new Car(fuel, consumption, tank);
                break;
            case "Truck":
                vehicle = new Truck(fuel, consumption, tank);
                break;
            case "Bus":
                vehicle = new Bus(fuel, consumption, tank);
                break;
        }
        return vehicle;
    }
}
