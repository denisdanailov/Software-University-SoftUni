package JavaAdvancedExamJune2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    int capacity;
    List<Pet> data;
    // Constructor
    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    // Methods
    public void add(Pet pet) {
        if (this.capacity > this.data.size() + 1) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).name.equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).name.equals(name) && this.data.get(i).owner.equals(owner)) {
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
        output.append("The grooming salon has the following clients:");
        output.append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            output.append(String.format("%s %s",this.data.get(i).name, this.data.get(i).owner));
            if (i != this.data.size() - 1) {
                output.append(System.lineSeparator());
            }
        }
        return output.toString();
    }
}
