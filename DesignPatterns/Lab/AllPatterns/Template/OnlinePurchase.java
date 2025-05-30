package DesignPatterns.Lab.AllPatterns.Template;

public class OnlinePurchase extends TemplatePurchase {
    @Override
    protected void getItemsFromCart() {
        System.out.println("Getting your items from your cart");
    }

    @Override
    protected void calculatePrices() {
        System.out.println("No discounts");
    }

    @Override
    protected void createReceipt() {
        System.out.println("Total: 199.99");
    }

    @Override
    protected void payOrder() {
        System.out.println("Paying with card");
    }

    @Override
    protected void notifyClient() {
        System.out.println("Sending email");
    }
}
