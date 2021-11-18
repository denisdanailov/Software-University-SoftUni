package reflectionAndAnnotation.lab.reflection;

import reflectionAndAnnotation.lab.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;
        System.out.println(reflectionClass);

        Class<? super Reflection> superclass = Reflection.class.getSuperclass();
        System.out.println(superclass);

        Class<?>[] interfaces = Reflection.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        try {
            Reflection newInstance = Reflection.class.getDeclaredConstructor().newInstance();
            System.out.println(newInstance);
        } catch (NoSuchMethodException | IllegalAccessException |
                InvocationTargetException | InstantiationException exception) {
            exception.printStackTrace();
        }
    }
}
