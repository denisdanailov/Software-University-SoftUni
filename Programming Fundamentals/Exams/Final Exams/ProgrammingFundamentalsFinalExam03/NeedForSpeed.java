package Exams.FinalExams.ProgrammingFundamentalsFinalExam03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed {

    public static class Car {
    String car;
    int mileage;
    int fuel;
    public Car (String name, int mileage, int fuel) {
      this.car = name;
      this.mileage = mileage;
      this.fuel = fuel;
    }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        //Добавяме колите в Мап
        Map<String, Car> garageMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\|");
            String car = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            Car newCar = new Car(car, mileage, fuel);
            garageMap.put(car, newCar);
        }

        String input = scan.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String action = tokens[0];
            String car = tokens[1];
            switch (action) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    if (garageMap.get(car).fuel >= fuel) {
                        garageMap.get(car).fuel -= fuel;
                        garageMap.get(car).mileage += distance;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (garageMap.get(car).mileage >= 100000) {
                            garageMap.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    int refillFuel = Integer.parseInt(tokens[2]);
                    if (garageMap.get(car).fuel + refillFuel <= 75) {
                        garageMap.get(car).fuel += refillFuel;
                        System.out.printf("%s refueled with %d liters%n", car, refillFuel);
                    } else {
                        int oldFuel = garageMap.get(car).fuel;
                        garageMap.get(car).fuel = 75;
                        System.out.printf("%s refueled with %d liters%n", car, 75 - oldFuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    if (garageMap.get(car).mileage - kilometers >= 10000) {
                        garageMap.get(car).mileage -= kilometers;
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    } else {
                        garageMap.get(car).mileage = 10000;
                    }
                    break;
            }
            input = scan.nextLine();
        }

        garageMap.entrySet().stream()
                .sorted((a,b) -> {
                    if (a.getValue().mileage != b.getValue().mileage) {
                        return Integer.compare(b.getValue().mileage, a.getValue().mileage);
                    } else {
                        return a.getValue().car.compareTo(b.getValue().car);
                    }
                })
                .forEach(entrySet -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entrySet.getValue().car, entrySet.getValue().mileage, entrySet.getValue().fuel));
    }
}
