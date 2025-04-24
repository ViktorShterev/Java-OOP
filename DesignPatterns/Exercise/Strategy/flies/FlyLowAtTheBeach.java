package DesignPatterns.Exercise.Strategy.flies;

public class FlyLowAtTheBeach implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Fly low at the beach");
    }
}
