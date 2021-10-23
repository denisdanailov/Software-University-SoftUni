package Exams.JavaAdvancedRetakeExamAugust2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    int capacity;
    List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() + 1 <= this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size();i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (int i = 0; i < this.data.size();i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).getOwner().equals(owner)) {
                return this.data.get(i);
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        int oldestAge = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < this.data.size();i++) {
            if (this.data.get(i).getAge() >= oldestAge) {
                index = i;
                oldestAge = this.data.get(i).getAge();
            }
        }
        return this.data.get(index);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("The clinic has the following patients:")
                .append(System.lineSeparator());
        for (int i = 0; i < this.data.size(); i++) {
            strBuild.append(String.format("%s %s", this.data.get(i).getName(), this.data.get(i).getOwner()))
                    .append(System.lineSeparator());
        }
        return strBuild.toString();
    }
}
