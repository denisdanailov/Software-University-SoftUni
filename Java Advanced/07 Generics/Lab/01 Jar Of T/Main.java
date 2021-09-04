package Generics.Lab.JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> newJar = new Jar<>();

        newJar.add("String");
        newJar.add("String");
        newJar.add("String");
        newJar.add("String");

        System.out.println(newJar.remove());
        System.out.println(newJar.remove());
        System.out.println(newJar.remove());
        System.out.println(newJar.remove());
    }
}
