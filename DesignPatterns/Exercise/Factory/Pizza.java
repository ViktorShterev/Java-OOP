package DesignPatterns.Exercise.Factory;

public abstract class Pizza {

    private double size;

    public Pizza(double size) {
        this.size = size;
    }

    abstract void preparing();
    abstract void baking();
    abstract void boxing();
}
