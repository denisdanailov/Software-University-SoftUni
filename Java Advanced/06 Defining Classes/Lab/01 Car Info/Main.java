package DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Car> carList = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);
            Car newCar = new Car(brand, model, horsePower);
            carList.add(newCar);
        }

        carList.forEach(System.out::println);
    }
}
