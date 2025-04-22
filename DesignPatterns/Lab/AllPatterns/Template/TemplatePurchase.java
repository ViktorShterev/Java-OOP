package DesignPatterns.Lab.AllPatterns.Template;

public abstract class TemplatePurchase {

    public final void purchaseOrder() {
        getItemsFromCart();
        calculatePrices();
        createReceipt();
        payOrder();
        notifyClient();
    }

    protected abstract void getItemsFromCart();

    protected abstract void calculatePrices();

    protected abstract void createReceipt();

    protected abstract void payOrder();

    protected abstract void notifyClient();


}
