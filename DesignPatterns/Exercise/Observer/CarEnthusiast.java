package DesignPatterns.Exercise.Observer;

public class CarEnthusiast implements Observer {
    @Override
    public void update(String magazineName) {
        System.out.println("Yes, my magazine is out " + magazineName);
    }
}
