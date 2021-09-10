package Exams.JavaAdvancedRetakeExamAugust2021.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    String name;
    int capacity;
    List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee newEmployee) {
        if (employees.size() < capacity) {
            employees.add(newEmployee);
        }
    }
    public boolean removeEmployee(String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).name.equals(name)) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }
    public Employee getOldestEmployee() {
        int oldestEmployeeIndex = 0;
        int maxAge = Integer.MIN_VALUE;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).age > maxAge) {
              oldestEmployeeIndex = i;
              maxAge = employees.get(i).age;
            }
        }
        return employees.get(oldestEmployeeIndex);
    }
    public Employee getEmployee(String name) {
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).name.equals(name)) {
                index = i;
            }
        }
        return employees.get(index);
    }
    public int getCount() {
        return employees.size();
    }
    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Employees working at Cafe ");
        output.append(String.format("%s:%n",this.name));
        for (int i = 0; i < employees.size(); i++) {
            output.append(String.format("%s%n",employees.get(i).toString()));

        }
        return output.toString();
    }
}
