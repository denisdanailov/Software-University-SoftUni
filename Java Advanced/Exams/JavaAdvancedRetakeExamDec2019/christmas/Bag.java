package Exams.JavaAdvancedRetakeExamDec2019.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    String color;
    int capacity;
    List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).name.equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        double heaviest = 0;
        int index = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getWeight() > heaviest) {
               heaviest = this.data.get(i).getWeight();
               index = i;
            }
        }
        return this.data.get(index);
    }

    public Present getPresent(String name) {
        int index = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) ) {
                index = i;
            }
        }
        return this.data.get(index);
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s bag contains:", this.getColor()))
                .append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            output.append(this.data.get(i))
                    .append(System.lineSeparator());
        }
        return output.toString();
    }
}
