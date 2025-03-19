package WorkingWithAbstraction.Lab.hotelReservation;

public class PriceCalculator {
    private double price;
    private int days;
    private String season;
    private String discount;

    public PriceCalculator(double price, int days, String season, String discount) {
        this.price = price;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }
    public double getSum() {
        double noDiscount = ((price * days) * Seasons.valueOf(season.toUpperCase()).getMultiply());
        double discountValue = noDiscount * Discount.valueOf(discount.toUpperCase()).getDiscount();
        return noDiscount - discountValue;
    }
}
