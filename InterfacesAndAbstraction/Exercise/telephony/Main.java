package InterfacesAndAbstraction.Exercise.telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        String[] sites = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(List.of(numbers), List.of(sites));

        for (String number : numbers) {
            boolean isLetter = false;
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) {
                    System.out.println("Invalid number!");
                    isLetter = true;
                    break;
                }
            }
            if (!isLetter) {
                System.out.println(smartphone.call() + number);
            }
        }
        for (String site : sites) {
            boolean isDigit = false;
            for (char c : site.toCharArray()) {
                if (Character.isDigit(c)) {
                    System.out.println("Invalid URL!");
                    isDigit = true;
                    break;
                }
            }
            if (!isDigit) {
                System.out.println(smartphone.browse() + site + "!");
            }
        }
    }
}
