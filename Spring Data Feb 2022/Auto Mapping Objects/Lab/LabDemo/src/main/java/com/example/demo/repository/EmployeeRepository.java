package com.example.demo.repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<EmployeeDTO> findAllByBirthDayBeforeOrderBySalaryDesc(LocalDate date);
}
