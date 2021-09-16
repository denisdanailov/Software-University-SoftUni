package Exams.JavaAdvancedExamFebruary2021.dealership;

import java.util.ArrayList;

public class Dealership {
    String name;
    int capacity;
    ArrayList<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).manufacturer.equals(manufacturer)
                    && this.data.get(i).model.equals(model)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.data.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public Car getLatestCar() {
        int latestCarYear = Integer.MIN_VALUE;
        int latestCarIndex = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).year > latestCarYear) {
                latestCarYear = this.data.get(i).year;
                latestCarIndex = i;
            }
        }
        if (latestCarIndex != -1) {
            return this.data.get(latestCarIndex);
        } else {
            return null;
        }
    }

    public Car getCar(String manufacturer, String model) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).manufacturer.equals(manufacturer)
                    && this.data.get(i).model.equals(model)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return this.data.get(index);
        } else {
            return null;
        }
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The cars are in a car dealership %s:%n",this.name));
        for (int i = 0; i < this.data.size(); i++) {
            output.append(this.data.get(i).toString());
            if (i != this.data.size() - 1) {
                output.append(System.lineSeparator());
            }
        }
        return output.toString().trim();
    }
}
