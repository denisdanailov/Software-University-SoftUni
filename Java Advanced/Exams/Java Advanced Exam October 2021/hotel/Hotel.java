package Exams.JavaAdvancedExamOctober2021RegularExam.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    String name;
    int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() + 1 <= this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index != -1) {
         this.roster.remove(index);
         return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name) && this.roster.get(i).getHometown().equals(hometown)) {
                index = i;
            }
        }
        if (index != -1) {
            return this.roster.get(index);
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(String.format("The people in the hotel %s are:", this.name))
                .append(System.lineSeparator());
        for (int i = 0; i < this.roster.size(); i++) {
            strBuild.append(this.roster.get(i))
                    .append(System.lineSeparator());
        }
        return strBuild.toString();
    }
}
