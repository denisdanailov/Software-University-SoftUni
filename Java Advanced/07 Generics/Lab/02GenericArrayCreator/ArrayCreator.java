package Generics.Lab.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator  {

    public static <Type> Type[] create(int length, Type element) {
        Type[] arr = (Type[])Array.newInstance(element.getClass(), length);

        for (int i = 0; i < length; i++) {
            arr[i] = element;
        }

        return arr;
    }

    public static <Type> Type[] create(Class<Type> clazz,int length, Type element) {
        Type[] arr = (Type[])Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            arr[i] = element;
        }

        return arr;
    }
}
