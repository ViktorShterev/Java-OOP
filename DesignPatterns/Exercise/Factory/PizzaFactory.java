package DesignPatterns.Exercise.Factory;

public class PizzaFactory {

    public Pizza createPizza(String pizzaType) {
        Pizza pizza = null;

        switch (pizzaType) {
            case "Bulgarian" -> pizza = new BulgarianPizza(40);
            case "Italian" -> pizza = new ItalianPizza(20);
        }
        return pizza;
    }
}
