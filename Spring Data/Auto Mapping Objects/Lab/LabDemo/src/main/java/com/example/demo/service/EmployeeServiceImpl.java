package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<String> findAllEmployeesByBirthdayBefore(int year) {
        LocalDate beforeDate = LocalDate.of(year, 01, 01);

        return employeeRepo.findAllByBirthDayBeforeOrderBySalaryDesc(beforeDate)
                .stream()
//                .map(e -> new ModelMapper().map(e, EmployeeDTO.class)) работи!
                .map(EmployeeDTO::toString)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }
}
