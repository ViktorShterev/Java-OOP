package InterfacesAndAbstraction.Lab.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            Identifiable identifiable = null;

            String[] tokens = command.split("\\s+");

            if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                identifiable = new Citizen(name, age, id);

            } else if (tokens.length == 2){
                String model = tokens[0];
                String robotId = tokens[1];

                identifiable = new Robot(model, robotId);
            }
            identifiables.add(identifiable);

            command = scanner.nextLine();
        }
        String digitsFake = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(digitsFake)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
