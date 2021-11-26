package reflectionAndAnnotation.lab.gettersAndSetters;

import reflectionAndAnnotation.lab.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Method[] methods = Reflection.class.getDeclaredMethods();

        List<Method> gettersList = new ArrayList<>();
        List<Method> settersList = new ArrayList<>();

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                gettersList.add(method);
            } else if (methodName.startsWith("set")) {
                settersList.add(method);
            }
        }

        // Sort

        gettersList.sort((a, b) -> a.getName().compareTo(b.getName()));
        settersList.sort((a, b) -> a.getName().compareTo(b.getName()));

        // Print
        gettersList.forEach(m -> System.out.printf("%s will return class %s%n",
                m.getName(),
                m.getReturnType().getSimpleName()));

        settersList.forEach(m -> System.out.printf("%s and will set field of class %s%n",
                m.getName(),
                m.getParameterTypes()[0].getSimpleName()));
    }
}
