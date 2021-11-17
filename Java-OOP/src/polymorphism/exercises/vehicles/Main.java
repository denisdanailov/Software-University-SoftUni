package polymorphism.exercises.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        Vehicle car = createVehicle(carInfo);

        String[] truckInfo = scan.nextLine().split("\\s+");
        Vehicle truck = createVehicle(truckInfo);

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            fulfillCommand(tokens, car, truck);
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }

    private static void fulfillCommand(String[] tokens, Vehicle car, Vehicle truck) {
        String typeCommand = tokens[0];
        String typeVehicle = tokens[1];

        switch (typeCommand) {
            case "Drive":
                double distance = Double.parseDouble(tokens[2]);
                switch (typeVehicle) {
                    case "Car":
                        System.out.println(car.drive(distance));
                        break;
                    case "Truck":
                        System.out.println(truck.drive(distance));
                        break;
                }
                break;
            case "Refuel":
                double liters = Double.parseDouble(tokens[2]);
                switch (typeVehicle) {
                    case "Car":
                        car.refuel(liters);
                        break;
                    case "Truck":
                        truck.refuel(liters);
                        break;
                }
                break;
        }
    }

    private static Vehicle createVehicle(String[] arr) {
        String vehicleType = arr[0];
        double fuelQuantity = Double.parseDouble(arr[1]);
        double fuelConsumption = Double.parseDouble(arr[2]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption);
            default:
                return null;
        }
    }
}
