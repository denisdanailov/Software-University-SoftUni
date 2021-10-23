package Exams.JavaAdvancedRetakeExamDecember2020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    String name;
    int capacity;
    List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() + 1 <= this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        int index = getEmployeeIndex(employees, name);
        if (index != -1) {
           this.employees.remove(index);
           return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int age = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getAge() >= age) {
               index = i;
               age = this.employees.get(i).getAge();
            }
        }
        return this.employees.get(index);
    }

    public Employee getEmployee(String name) {
        int index = getEmployeeIndex(employees, name);
        return this.employees.get(index);
    }

    private int getEmployeeIndex(List<Employee> employees, String name) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(String.format("Employees working at Bakery %s:", this.name))
                .append(System.lineSeparator());
        for (int i = 0; i < this.employees.size(); i++) {
           strBuild.append(this.employees.get(i).toString());
           strBuild.append(System.lineSeparator());
        }
        return strBuild.toString().trim();
    }
}

