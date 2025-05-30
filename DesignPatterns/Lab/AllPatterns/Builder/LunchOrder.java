package Builder;

public class LunchOrder {

    public static class Builder {

        private LunchOrder lunchOrder;
        private Builder() {
            this.lunchOrder = new LunchOrder();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder withBread(String bread) {
            this.lunchOrder.setBread(bread);
            return this;
        }
        public Builder withMeat(String meat) {
            this.lunchOrder.setMeat(meat);
            return this;
        }
        public Builder withSalad(String salad) {
            this.lunchOrder.setSalad(salad);
            return this;
        }
        public Builder withDrink(String drink) {
            this.lunchOrder.setDrink(drink);
            return this;
        }

        public LunchOrder build() {
            return this.lunchOrder;
        }
    }

    private String bread;
    private String meat;
    private String salad;
    private String drink;

    public LunchOrder() {
    }

    private void setBread(String bread) {
        this.bread = bread;
    }

    private void setMeat(String meat) {
        this.meat = meat;
    }

    private void setSalad(String salad) {
        this.salad = salad;
    }

    private void setDrink(String drink) {
        this.drink = drink;
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public String getSalad() {
        return salad;
    }

    public String getDrink() {
        return drink;
    }
}
