package Polymorphism.Exercise.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            Animal animal = getAnimal(command);

            Food food = getFood(scanner);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);

            command = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        String type = tokens[0];
        Integer quantity = Integer.parseInt(tokens[1]);

        Food food = null;

        switch (type) {
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
            case "Meat":
                food = new Meat(quantity);
                break;
        }
        return food;
    }

    private static Animal getAnimal(String command) {
        String[] tokens = command.split("\\s+");
        String type = tokens[0];
        String name = tokens[1];
        Double weight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        Animal animal = null;

        switch (type) {
            case "Cat":
                String breed = tokens[4];
                animal = new Cat(name, type, weight, livingRegion, breed);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight,livingRegion);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name,type, weight, livingRegion);
                break;
        }
        return animal;
    }
}
