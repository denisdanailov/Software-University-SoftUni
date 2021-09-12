package DefiningClasses.Lab.CarConstructors;

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
            int length = tokens.length;
            carList.add(getCarObj(length, tokens));
        }

        carList.forEach(System.out::println);
    }

    public static Car getCarObj(int length, String[] tokens) {
        Car newCar;
        //If the length is three there is only one outcome: brand, model, horsePower.
        if (length == 3) {
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);
            newCar = new Car(brand, model, horsePower);
        } else if (length == 2){
            //If the length is two there is only one outcome: brand, horsePower (because constructor can't have both
            //brand, horsePower and model, horsePower -> because having two identical constructors taking
            // Strings and int is a compile time error).
            String brand = tokens[0];
            int horsePower = Integer.parseInt(tokens[1]);
            newCar = new Car(brand,horsePower);
        } else {
            //If the length is one there are two outcomes: brand || horsepower (because constructor can't have both
            //brand and model -> because having two identical constructors taking only Strings is a compile time error).
            if (isInteger(tokens[0])) {
                int horsePower = Integer.parseInt(tokens[0]);
                newCar = new Car(horsePower);
            } else {
                String brand = tokens[0];
                newCar = new Car(brand);
            }
        }
        return newCar;
    }

    public static boolean isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
