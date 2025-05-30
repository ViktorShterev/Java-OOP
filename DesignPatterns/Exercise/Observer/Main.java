package DesignPatterns.Exercise.Observer;

public class Main {
    public static void main(String[] args) {

        Observer carFan1 = new CarEnthusiast();
        Observer carFan2 = new CarEnthusiast();
        Observer carFan3 = new CarEnthusiast();

        Subject carMagazine = new CarMagazine();

        carMagazine.subscribe(carFan1);
        carMagazine.subscribe(carFan2);
        carMagazine.subscribe(carFan3);

        carMagazine.notify("First copy");

        carMagazine.unSubscribe(carFan2);
    }
}
