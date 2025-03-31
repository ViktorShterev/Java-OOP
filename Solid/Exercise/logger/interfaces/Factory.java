package Solid.Exercise.logger.interfaces;

public interface Factory<T> {

    T produce(String input);
}
