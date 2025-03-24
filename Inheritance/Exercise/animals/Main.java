package Inheritance.Exercise.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Beast!")) {

            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String gender = input[2];

            try {
                switch (command) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        animals.add(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        animals.add(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
