package DesignPatterns.Lab.AllPatterns.Builder;

public class BuilderMain {
    public static void main(String[] args) {

        Builder.LunchOrder order = Builder.LunchOrder.Builder.get()
                .withBread("white bread")
                .withMeat("Beef")
                .withDrink("Beer")
                .build();
    }
}
