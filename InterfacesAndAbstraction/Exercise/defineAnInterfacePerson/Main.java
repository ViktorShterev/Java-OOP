package InterfacesAndAbstraction.Exercise.defineAnInterfacePerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");

            String type = tokens[0];

            if (type.equals("Citizen")) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];

                birthables.add(new Citizen(name, age, id, birthDate));

            } else if (type.equals("Robot")) {
                String model = tokens[1];
                String id = tokens[2];

            } else if (type.equals("Pet")) {
                String name = tokens[1];
                String birthDate = tokens[2];

                birthables.add(new Pet(name, birthDate));
            }
            line = scanner.nextLine();
        }
        String date = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(date)) {
                System.out.println(birthable.getBirthDate());
            }
        }
//        System.out.println(birthables.stream()
//                .map(Birthable::getBirthDate)
//                .filter(e -> e.endsWith(date))
//                .collect(Collectors.joining()));
    }
}
