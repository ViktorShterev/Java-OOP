public class DecreaseProductPriceCommand implements CommandP {
    private final ProductP product;
    private final int amount;

    public DecreaseProductPriceCommand(ProductP product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public String executeAction() {
        this.product.decreasePrice(this.amount);
        return String.format("The price for the %s has been decreased by %d$.%n",
                this.product.getName(), this.amount);
    }
}

