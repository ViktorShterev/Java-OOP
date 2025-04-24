package DesignPatterns.Exercise.Factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String pizzaType = new Scanner(System.in).nextLine();

        PizzaFactory pizzaFactory = new PizzaFactory();

        Pizza pizza = pizzaFactory.createPizza(pizzaType);

        pizza.preparing();
        pizza.baking();
        pizza.boxing();
    }
}
