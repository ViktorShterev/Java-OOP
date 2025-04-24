package DesignPatterns.Exercise.Strategy.flies;

public class FlyHigh implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Fly high");
    }
}
