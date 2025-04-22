package Prototype;

public abstract class Item implements MyCloneable<Item>, Cloneable {
    private String name;
    private String imURL;
    private Double price;

    public Item(String name, String imURL, Double price) {
        this.name = name;
        this.imURL = imURL;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImURL() {
        return imURL;
    }

    public void setImURL(String imURL) {
        this.imURL = imURL;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Item clone() throws CloneNotSupportedException{
        return (Item) super.clone();
    }
}
