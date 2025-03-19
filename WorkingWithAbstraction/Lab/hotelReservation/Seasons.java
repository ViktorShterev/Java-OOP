package WorkingWithAbstraction.Lab.hotelReservation;

public enum Seasons {

    AUTUMN(1), SPRING(2), WINTER(3), SUMMER(4);

    private int multiply;

    Seasons(int multiply) {
        this.multiply = multiply;
    }

    public int getMultiply() {
        return multiply;
    }
}
