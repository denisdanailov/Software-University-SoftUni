package Generics.Lab.GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> newIntScale = new Scale<>(1, 3);
        Scale<String> newStrScale = new Scale<>("String", "Java");

        System.out.println(newIntScale.getHeavier());
        System.out.println(newStrScale.getHeavier());
    }
}
