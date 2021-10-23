package Exams.JavaAdvancedExamJune2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    String type;
    int capacity;
    List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data= new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
            this.data.get(i).getModel().equals(model)) {
              this.data.remove(i);
              return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.isEmpty()) {
            return null;
        }
        int latestYear = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getYear() >= latestYear) {
                latestYear = this.data.get(i).getYear();
                index = i;
            }
        }
        return this.data.get(index);
    }

    public Car getCar(String manufacturer, String model) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
                    this.data.get(i).getModel().equals(model)) {
                index = i;
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
        output.append(String.format("The cars are parked in %s:", this.type))
                .append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            output.append(this.data.get(i)).append(System.lineSeparator());
        }
        return output.toString();
    }
}
