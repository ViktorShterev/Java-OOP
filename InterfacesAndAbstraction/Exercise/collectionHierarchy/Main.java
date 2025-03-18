package InterfacesAndAbstraction.Exercise.collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = scanner.nextLine().split("\\s+");
        int removes = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        printAdd(items, addCollection);
        printAdd(items, addRemoveCollection);
        printAdd(items, myList);

        printRemove(removes, addRemoveCollection);
        printRemove(removes, myList);
    }

    private static void printRemove(int removes, AddRemovable collection) {
        for (int i = 0; i < removes; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void printAdd(String[] items, Addable collection) {
        for (String item : items) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();
    }
}
