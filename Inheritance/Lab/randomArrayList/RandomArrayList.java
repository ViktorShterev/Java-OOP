package Inheritance.Lab.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement() {
        int end = super.size();
        Random random = new Random();
        int randomInt = random.nextInt(size());
        return remove(randomInt);
    }
}
