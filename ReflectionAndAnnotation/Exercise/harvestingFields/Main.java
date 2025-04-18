package ReflectionAndAnnotation.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command = scanner.nextLine();

		while (!command.equals("HARVEST")) {

			Class<RichSoilLand> clazz = RichSoilLand.class;
			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				switch (command) {
					case "private":
						if (Modifier.isPrivate(field.getModifiers())) {
							print(field);
						}
						break;
					case "public":
						if (Modifier.isPublic(field.getModifiers())) {
							print(field);
						}
						break;
					case "protected":
						if (Modifier.isProtected(field.getModifiers())) {
							print(field);
						}
						break;
					case "all":
						print(field);
						break;
				}
			}
			command = scanner.nextLine();
		}
	}

	private static void print(Field field) {
		System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
	}
}
