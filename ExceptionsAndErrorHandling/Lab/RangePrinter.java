package ExceptionsAndErrorHandling.Lab;

import java.util.Scanner;

public class RangePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());

                printNumbers(start, end);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void printNumbers(int start, int end) {
        if (start > 1 && end > start && end < 100) {
            for (int i = start; i <= end; i++) {
                System.out.println(i);
            }
        } else {
            throw new IllegalArgumentException("Invalid number!");
        }
    }
}
