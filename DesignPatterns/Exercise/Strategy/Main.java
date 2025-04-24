package DesignPatterns.Exercise.Strategy;

import DesignPatterns.Exercise.Strategy.flies.FlyHigh;
import DesignPatterns.Exercise.Strategy.flies.FlyLowAtTheBeach;
import DesignPatterns.Exercise.Strategy.flies.NoFly;

public class Main {
    public static void main(String[] args) {

        Bird seagull = new Bird(new FlyLowAtTheBeach());
        seagull.fly();
        seagull.setStrategy(new NoFly());
        seagull.fly();

        Bird eagle = new Bird(new FlyHigh());
        eagle.fly();
    }
}
