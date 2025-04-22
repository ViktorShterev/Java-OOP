package DesignPatterns.Lab.AllPatterns.Singleton;

public class DemoSingleton {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        DBInstance dbInstance = DBInstance.getInstance();
        dbInstance.createTable();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(dbInstance);

        start = System.currentTimeMillis();

        DBInstance dbInstanceTwo = DBInstance.getInstance();
        dbInstanceTwo.createTable();

        end = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(dbInstanceTwo);
    }
}
