package DesignPatterns.Lab.AllPatterns.Template;

public class TemplateMain {
    public static void main(String[] args) {

        TemplatePurchase purchase1 = new OnlinePurchase();
        TemplatePurchase purchase2 = new LocalStorePurchase();

        purchase1.purchaseOrder();

        System.out.println();

        purchase2.purchaseOrder();
    }
}
