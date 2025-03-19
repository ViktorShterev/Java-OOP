package WorkingWithAbstraction.Lab.hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discount = tokens[3];

        PriceCalculator priceCalculator = new PriceCalculator(price, days, season, discount);

        System.out.printf("%.2f", priceCalculator.getSum());
    }
}
