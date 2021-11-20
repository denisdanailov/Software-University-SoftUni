package reflectionAndAnnotation.exercises.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            switch (command) {
                case "add":
                    Method addMethod = blackBoxIntClass.getDeclaredMethod("add", int.class);
                    invokeMethod(blackBoxInt, value, addMethod);
                    break;
                case "subtract":
                    Method subtractMethod = blackBoxIntClass.getDeclaredMethod("subtract", int.class);
                    invokeMethod(blackBoxInt, value, subtractMethod);
                    break;
                case "multiply":
                    Method multiplyMethod = blackBoxIntClass.getDeclaredMethod("multiply", int.class);
                    invokeMethod(blackBoxInt, value, multiplyMethod);
                    break;
                case "divide":
                    Method divideMethod = blackBoxIntClass.getDeclaredMethod("divide", int.class);
                    invokeMethod(blackBoxInt, value, divideMethod);
                    break;
                case "leftShift":
                    Method leftShiftMethod = blackBoxIntClass.getDeclaredMethod("leftShift", int.class);
                    invokeMethod(blackBoxInt, value, leftShiftMethod);
                    break;
                case "rightShift":
                    Method rightShiftMethod = blackBoxIntClass.getDeclaredMethod("rightShift", int.class);
                    invokeMethod(blackBoxInt, value, rightShiftMethod);
                    break;
            }

            Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));


            input = scan.nextLine();
        }
    }

    private static void invokeMethod(BlackBoxInt blackBoxInt, int value, Method method) throws IllegalAccessException, InvocationTargetException {
        method.setAccessible(true);
        method.invoke(blackBoxInt, value);
    }
}
