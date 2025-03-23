package Encapsulation.Exercise.pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int numberOfToppings;
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() < 1 || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setToppings(int toppings) {
        if (toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = toppings;
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }
    public double getOverallCalories() {
        double sumCal = 0;
        for (Topping topping : toppings) {
            sumCal += topping.calculateCalories();
        }
       return this.dough.calculateCalories() + sumCal;
    }
}
