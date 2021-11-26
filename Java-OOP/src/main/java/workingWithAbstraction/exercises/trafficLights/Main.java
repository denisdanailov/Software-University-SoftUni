package workingWithAbstraction.exercises.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] signals = scan.nextLine().split("\\s+");

        List<TrafficLight> trafficLightList = new ArrayList<>();
        for (String signal : signals) {
            TrafficLight newTrafficLight = new TrafficLight(Color.valueOf(signal));
            trafficLightList.add(newTrafficLight);
        }


        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLightList) {
                trafficLight.changeColor();
                System.out.print(trafficLight.toString() + " ");
            }
            System.out.println("");
        }
    }
}
