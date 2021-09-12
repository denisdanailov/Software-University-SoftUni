package Generics.Lab.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(5, "String");

        Integer[] integers = ArrayCreator.create(Integer.class, 5, 13);

        System.out.println("");
    }
}
