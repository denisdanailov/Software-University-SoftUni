package Exams.JavaAdvancedRetakeExamAugust2021.cafe;

public class Employee {
    String name;
    int age;
    String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getCountry() {
        return this.country;
    }
    public String toString() {
        return String.format("Employee: %s, %d from %s", name, age, country);
    }
}
