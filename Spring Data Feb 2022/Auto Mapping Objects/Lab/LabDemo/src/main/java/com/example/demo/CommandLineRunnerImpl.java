package com.example.demo;


import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.service.AddressService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private EmployeeService employeeService;
    private AddressService addressService;

    @Autowired
    public CommandLineRunnerImpl(EmployeeService employeeService, AddressService addressService) {
        this.employeeService = employeeService;
        this.addressService = addressService;
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address("Sofia", "Vasil Levski", 15);
        addressService.save(address);

        Employee employee1 = new Employee("Pesho", "Peshev", BigDecimal.TEN, LocalDate.of(1987, 10, 12), address, null);
        Employee employee2 = new Employee("Zdravko", "Zdravkov", BigDecimal.ONE, LocalDate.of(1984, 6, 12), address, employee1);
        Employee employee3 = new Employee("Mila", "Mileva", BigDecimal.ONE, LocalDate.of(1990, 1, 1), address, null);
        Employee employee4 = new Employee("Milko", "Milkov", BigDecimal.ONE, LocalDate.of(1989, 12, 31), address, employee3);
        Employee employee5 = new Employee("Milko", "Milkov", BigDecimal.ONE, LocalDate.of(1992, 12, 10), address, employee3);
        Employee employee6 = new Employee("Milko", "Milkov", BigDecimal.ONE, LocalDate.of(1997, 12, 10), address, null);

        employeeService.save(employee1);
        employeeService.save(employee2);
        employeeService.save(employee3);
        employeeService.save(employee4);
        employeeService.save(employee5);
        employeeService.save(employee6);

        employeeService.findAllEmployeesByBirthdayBefore(1990)
                .forEach(System.out::println);

    }
}
