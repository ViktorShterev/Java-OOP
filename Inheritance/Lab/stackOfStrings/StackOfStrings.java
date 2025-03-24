package Inheritance.Lab.stackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;
    int index = 0;

    public StackOfStrings(List<String> data) {
        this.data = new ArrayList<>();
    }
    public void push(String string) {
        this.data.add(string);
        this.index++;
    }
    public String peek() {
        return this.data.get(this.index);
    }
    public String pop() {
        return this.data.remove(this.index--);
    }
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
