package reflectionAndAnnotation.lab.highQualityMistakes;

import reflectionAndAnnotation.lab.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Field[] fields = Reflection.class.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((a,b) -> a.getName().compareTo(b.getName()))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> !m.getName().equals("toString")
                        && m.getReturnType() != void.class
                        && !Modifier.isPublic(m.getModifiers()))
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(m -> System.out.printf("%s have to be public!%n", m.getName()));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> m.getReturnType() == void.class && !Modifier.isPrivate(m.getModifiers()))
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(m -> System.out.printf("%s have to be private!", m.getName()));
    }
}
