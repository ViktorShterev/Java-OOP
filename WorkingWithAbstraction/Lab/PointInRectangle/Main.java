package WorkingWithAbstraction.Lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = readData(scanner);

        Point pointA = new Point(coordinates[0], coordinates[1]);
        Point pointB = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(pointA, pointB);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int[] input = readData(scanner);

            Point p = new Point(input[0], input[1]);

            boolean isInside = rectangle.isInside(p);

            System.out.println(isInside);
        }
    }

    public static int[] readData(Scanner scanner) {
       return Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
