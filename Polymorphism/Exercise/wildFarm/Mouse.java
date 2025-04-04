package Polymorphism.Exercise.wildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight,
                 String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }
        super.eat(food);
    }
}
