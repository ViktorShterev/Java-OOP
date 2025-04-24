package DesignPatterns.Exercise.Builder;

public class Pizza {
    private String name;
    private String topping;
    private int size;
    private int weight;
    private boolean isHot;
    private boolean hasMeat;
    private boolean containsTomatoes;

    public Pizza() {
    }

    public Pizza withName(String name) {
        this.name = name;
        return this;
    }
    public Pizza withTopping(String topping) {
        this.topping = topping;
        return this;
    }
    public Pizza withWeight(int weight) {
        this.weight = weight;
        return this;
    }
}
