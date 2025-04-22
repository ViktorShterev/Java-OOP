public class IncreaseProductPriceCommand implements CommandP {
    private final ProductP product;
    private final int amount;

    public IncreaseProductPriceCommand(ProductP product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public String executeAction() {
        this.product.increasePrice(this.amount);
        return String.format("The price for the %s has been increased by %d$.%n",
                this.product.getName(), this.amount);
    }
}


