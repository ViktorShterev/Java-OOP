package Builder;

public class BuilderMain {
    public static void main(String[] args) {

        LunchOrder order = LunchOrder.Builder.get()
                .withBread("white bread")
                .withMeat("Beef")
                .withDrink("Beer")
                .build();
    }
}
