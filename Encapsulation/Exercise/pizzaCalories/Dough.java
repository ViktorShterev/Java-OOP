package Encapsulation.Exercise.pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy")
        || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    public double calculateCalories() {
        double flourCal = 0;
        if (this.flourType.equals("White")) {
            flourCal = 1.5;
        } else {
            flourCal = 1.0;
        }

        double bakingCal = 0;
        if (this.bakingTechnique.equals("Crispy")) {
            bakingCal = 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            bakingCal = 1.1;
        } else {
            bakingCal = 1.0;
        }

        return (2 * this.weight) * flourCal * bakingCal;
    }
}
