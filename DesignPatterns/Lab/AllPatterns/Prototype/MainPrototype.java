package DesignPatterns.Lab.AllPatterns.Prototype;

public class MainPrototype {
    public static void main(String[] args) {

        Register register = new Register();

        Item book = register.getItem("Book");

        System.out.println(book);
    }
}
