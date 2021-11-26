package encapsulation.lab.SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName,age,0.0);
    }

    public void increaseSalary(double bonus) {
        bonus /= 100;
        if (this.age < 30) {
            this.salary += salary * (bonus / 2);
        } else {
            this.salary += salary * bonus;
        }
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.0##");
        return String.format("%s %s gets %s leva",
                this.getFirstName(),
                this.getLastName(),
                formatter.format(this.salary));
    }
}
