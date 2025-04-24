package DesignPatterns.Exercise.Strategy;

import DesignPatterns.Exercise.Strategy.flies.FlyStrategy;

public class Bird {
    private FlyStrategy strategy;

    public void fly() {
        this.strategy.fly();
    }
    public Bird(FlyStrategy strategy) {
        this.strategy = strategy;
    }

    public FlyStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(FlyStrategy strategy) {
        this.strategy = strategy;
    }
}
