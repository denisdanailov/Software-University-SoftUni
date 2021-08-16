package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    public static class Vehicle {
        String type;
        String model;
        String color;
        int hp;

        public Vehicle(String type, String model, String color, int hp) {
            this.type=type;
            this.model=model;
            this.color=color;
            this.hp=hp;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Vehicle> list = new ArrayList<>();

        while (!input.equals("End")) {
            String[] token = input.split(" ");

            Vehicle vehicle = new Vehicle(token[0], token[1], token[2], Integer.parseInt(token[3]));

            list.add(vehicle);

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("Close the Catalogue")) {

            for (int i = 0; i < list.size(); i++) {
            if (list.get(i).model.equals(input)){
                if (list.get(i).type.equals("car")){
                    System.out.println("Type: Car");
                } else if (list.get(i).type.equals("truck")){
                    System.out.println("Type: Truck");
                }
                System.out.println("Model: " + list.get(i).model);
                System.out.println("Color: " + list.get(i).color);
                System.out.println("Horsepower: " + list.get(i).hp);
                break;
            }
            }
            input = scan.nextLine();
        }

        double sumHpCars = 0;
        int countCars = 0;
        double sumHpTrucks = 0;
        int countTrucks = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).type.equals("car")) {
                sumHpCars += list.get(i).hp;
                countCars++;
            } else if (list.get(i).type.equals("truck")) {
                sumHpTrucks += list.get(i).hp;
                countTrucks++;
            }
        }
        if (sumHpCars != 0) {
            System.out.printf("Cars have average horsepower of: %.02f.%n", sumHpCars / countCars);
        } else {
            System.out.printf("Cars have average horsepower of: %.02f.%n", sumHpCars);
        }

        if (sumHpTrucks != 0) {
            System.out.printf("Trucks have average horsepower of: %.02f.%n", sumHpTrucks / countTrucks);
        } else {
            System.out.printf("Trucks have average horsepower of: %.02f.%n", sumHpTrucks);
        }

    }
}
