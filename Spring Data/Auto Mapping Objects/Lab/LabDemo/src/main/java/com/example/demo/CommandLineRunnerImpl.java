package com.example.demo;


import com.example.demo.dto.CustomDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.service.AddressService;
import com.example.demo.service.EmployeeService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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

//        persistEntities();

        _03_Projection();

//        customDTO();
    }

    private void customDTO() {
        CustomDTO customDTO = new CustomDTO("Ivan", "Ivanovic", 135.00, "Doe");

        ModelMapper modelMapper = new ModelMapper();
        TypeMap<CustomDTO, Employee> typeMap = modelMapper.createTypeMap(CustomDTO.class, Employee.class);

        Converter<String, String> toUpperCase = context -> context.getSource() == null ? null : context.getSource().toUpperCase();
        Converter<String, String> toLowerCase = context -> context.getSource() == null ? null : context.getSource().toLowerCase();
        Converter<String, Employee> newEmployee = context -> context.getSource() == null ? null :
                new Employee("John", context.getSource(), BigDecimal.TEN,LocalDate.now(),null, null);

        typeMap.addMappings(m -> m.when(Objects::nonNull).using(toLowerCase).map(CustomDTO::getFirstName, Employee::setFirstName))
                .addMappings(m -> m.when(Objects::nonNull).using(toUpperCase).map(CustomDTO::getLastName, Employee::setLastName))
                .addMappings(m -> m.when(Objects::nonNull).<Double>map(CustomDTO::getSalary, (destination, value) -> destination.setSalary(new BigDecimal(value))))
                .addMappings(m -> m.when(Objects::nonNull).using(newEmployee).map(CustomDTO::getManagerLastName, Employee::setManager))
                .addMappings(m -> m.skip(Employee::setAddress))
                .addMappings(m -> m.skip(Employee::setBirthDay));

        typeMap.validate();
        Employee employee = typeMap.map(customDTO);
    }

    private void _03_Projection() {
        employeeService.findAllEmployeesByBirthdayBefore(1990)
                .forEach(System.out::println);
    }

    private void persistEntities() {
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
    }
}
