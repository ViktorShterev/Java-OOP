package DesignPatterns.Exercise.Strategy.flies;

public class NoFly implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("Cannot fly");
    }
}
