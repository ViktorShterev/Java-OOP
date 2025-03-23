package Encapsulation.Exercise.shoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personsMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new HashMap<>();

        String[] people = scanner.nextLine().split(";");
        for (String person : people) {
            String[] individual = person.split("=");
            String name = individual[0];
            double money = Double.parseDouble(individual[1]);

            try {
                Person person1 = new Person(name, money);
                personsMap.put(person1.getName(), person1);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] products = scanner.nextLine().split(";");
        for (String product : products) {
            String[] individual = product.split("=");
            String productName = individual[0];
            double cost = Double.parseDouble(individual[1]);

            try {
                Product product1 = new Product(productName, cost);
                productMap.put(product1.getName(), product1);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String nameProduct = tokens[1];

            try {
                personsMap.get(personName).buyProduct(productMap.get(nameProduct));

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }
        for (Person person : personsMap.values()) {
            System.out.print(person.getName() + " - ");

            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream()
                        .map(Product::getName).collect(Collectors.joining(", ")));
            }
        }
    }
}
