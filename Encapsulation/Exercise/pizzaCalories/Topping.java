package Encapsulation.Exercise.pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies")
        || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + "weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
    public double calculateCalories() {
        double toppingCal = 0;
        if (toppingType.equals("Meat")) {
            toppingCal = 1.2;
        } else if (toppingType.equals("Veggies")) {
            toppingCal = 0.8;
        } else if (toppingType.equals("Cheese")) {
            toppingCal = 1.1;
        } else {
            toppingCal = 0.9;
        }
        return (2 * this.weight) * toppingCal;
    }
}
