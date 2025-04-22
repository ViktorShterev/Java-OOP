public class Main {
    public static void main(String[] args) {
        ModifyPriceP modifyPrice = new ModifyPriceP();
        ProductP product = new ProductP("Phone",500);

        execute(modifyPrice, new IncreaseProductPriceCommandP(product, 100));
        execute(modifyPrice, new IncreaseProductPriceCommandP(product, 50));
        execute(modifyPrice, new DecreaseProductPriceCommandP(product, 25));

        System.out.println(product);
    }
    private static void execute(ModifyPriceP modifyPrice, CommandP productCommand){
        modifyPrice.setCommand(productCommand);
        modifyPrice.invoke();
    }
}


