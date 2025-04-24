package DesignPatterns.Exercise.Builder;

public class Main {
    public static void main(String[] args) {

        Pizza pizza = new Pizza()
                .withName("Marga")
                .withTopping("Ketchup")
                .withWeight(400);
    }
}
