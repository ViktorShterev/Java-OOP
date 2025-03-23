package Encapsulation.Exercise.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInput = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInput[1];
        int numToppings = Integer.parseInt(pizzaInput[2]);

        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInput = scanner.nextLine().split("\\s+");
        String flourType = doughInput[1];
        String bakingTech = doughInput[2];
        double weight = Double.parseDouble(doughInput[3]);

        try {
            Dough dough = new Dough(flourType, bakingTech, weight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] toppingInput = command.split("\\s+");
            String toppingName = toppingInput[1];
            double weightTopping = Double.parseDouble(toppingInput[2]);

            try {
                Topping topping = new Topping(toppingName, weightTopping);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            command = scanner.nextLine();
        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
