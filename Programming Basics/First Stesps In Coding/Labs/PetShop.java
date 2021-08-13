package FirstStepsInCoding.Labs;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dogs = Integer.parseInt(scan.nextLine());
        int animals = Integer.parseInt(scan.nextLine());

        Double sumDogs = dogs * 2.50;
        Double sumAnimals = animals * 4.0;

        Double result = sumDogs + sumAnimals;

        System.out.println(result);
    }
}
