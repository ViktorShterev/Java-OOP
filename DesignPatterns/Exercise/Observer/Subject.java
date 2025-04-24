package DesignPatterns.Exercise.Observer;

public interface Subject {
    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void notify(String text);
}
