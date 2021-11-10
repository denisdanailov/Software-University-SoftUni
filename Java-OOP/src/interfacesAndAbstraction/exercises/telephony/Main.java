package interfacesAndAbstraction.exercises.telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> phoneNumbers = Arrays.asList(scan.nextLine().split("\\s+"));
        List<String> urls = Arrays.asList(scan.nextLine().split("\\s+"));

        Smartphone smartphone = new Smartphone(phoneNumbers, urls);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
