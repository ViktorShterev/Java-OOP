package WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printFigure(n);

    }
    public static void printSpaces(int n) {
        for (int j = 0; j < n; j++) {
            System.out.print(" ");
        }
    }
    public static void printStars(int n) {
        for (int j = 0; j < n; j++) {
            System.out.print("* ");
        }
    }
    public static void printTop(int n) {
        for (int i = 1; i < n; i++) {
            printSpaces(n - i);

            printStars(i);

            System.out.println();
        }
    }
    public static void printMiddle(int n) {
        printStars(n);
        System.out.println();
    }
    public static void printBottom(int n) {
        for (int i = 1; i < n; i++) {
            printSpaces(i);

            printStars(n - i);

            System.out.println();
        }
    }
    public static void printFigure(int n) {
        printTop(n);
        printMiddle(n);
        printBottom(n);
    }
}
