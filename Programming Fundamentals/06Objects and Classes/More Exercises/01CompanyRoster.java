package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyRoster {
    public static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email = "n/a";
        int age = -1;

        public Employee (String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
        }
    }

    public static class Department {
        List <Employee> employees = new ArrayList <>();
        public Department(List <Employee> employees) {
            this.employees = employees;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
           String[] tokens = scan.nextLine().split(" ");
           Employee employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3]);

           employeeList.add(employee);
        }
    }
}
