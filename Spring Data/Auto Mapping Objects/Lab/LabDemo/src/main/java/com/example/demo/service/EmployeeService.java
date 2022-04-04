package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<String> findAllEmployeesByBirthdayBefore(int date);

    void save(Employee employee);
}
