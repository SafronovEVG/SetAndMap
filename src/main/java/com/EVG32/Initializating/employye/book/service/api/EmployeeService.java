package com.EVG32.Initializating.employye.book.service.api;

import com.EVG32.Initializating.employye.book.domain.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    String findEmployee(Employee employee);

    List<Employee> findAllEmployees();
}
