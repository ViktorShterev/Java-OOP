package DesignPatterns.Exercise.Factory;

public class ItalianPizza extends Pizza {

    public ItalianPizza(double size) {
        super(size);
    }

    @Override
    void preparing() {
        System.out.println("italian pizza preparing");
    }

    @Override
    void baking() {
        System.out.println("italian pizza baking");
    }

    @Override
    void boxing() {
        System.out.println("italian pizza boxing");
    }
}
