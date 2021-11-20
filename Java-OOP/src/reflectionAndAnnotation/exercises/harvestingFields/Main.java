package reflectionAndAnnotation.exercises.harvestingFields;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] fields = richSoilLandClass.getDeclaredFields();

		String input = scan.nextLine();
		while (!input.equals("HARVEST")) {
			switch (input) {
				case "private":
					Arrays.stream(fields)
							.filter(f -> Modifier.isPrivate(f.getModifiers()))
							.forEach(Main::printField);
					break;
				case "protected":
					Arrays.stream(fields)
							.filter(f -> Modifier.isProtected(f.getModifiers()))
							.forEach(Main::printField);
					break;
				case "public":
					Arrays.stream(fields)
							.filter(f -> Modifier.isPublic(f.getModifiers()))
							.forEach(Main::printField);
					break;
				case "all":
					Arrays.stream(fields).forEach(Main::printField);
					break;
			}
			input = scan.nextLine();
		}

	}

	private static PrintStream printField(Field f) {
		return System.out.printf("%s %s %s%n",
				Modifier.toString(f.getModifiers()),
				f.getType().getSimpleName(),
				f.getName());
	}
}
