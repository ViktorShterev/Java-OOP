package InterfacesAndAbstraction.Exercise.foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<Person, Buyer> personBuyerMap = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Person person = null;

            if (tokens.length == 4) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];

                person = new Citizen(name, age, id, birthDate);

            } else {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];

                person = new Rebel(name, age, group);
            }
            Buyer buyer = (Buyer) person;

            personBuyerMap.put(person, buyer);
        }
        String command = scanner.nextLine();
        int sum = 0;

        while (!command.equals("End")) {

            for (Map.Entry<Person, Buyer> entry : personBuyerMap.entrySet()) {
                if (entry.getKey().getName().equals(command)) {
                    entry.getValue().buyFood();

                    if (entry.getKey().getClass().getSimpleName().equals("Citizen")) {
                        sum += 10;
                    } else {
                        sum += 5;
                    }
                    break;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
