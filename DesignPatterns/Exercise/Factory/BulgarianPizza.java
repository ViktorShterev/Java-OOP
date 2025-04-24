package DesignPatterns.Exercise.Factory;

public class BulgarianPizza extends Pizza {

    public BulgarianPizza(double size) {
        super(size);
    }

    @Override
    void preparing() {
        System.out.println("bg pizza preparing");
    }

    @Override
    void baking() {
        System.out.println("bg pizza baking");
    }

    @Override
    void boxing() {
        System.out.println("bg pizza boxing");
    }
}
