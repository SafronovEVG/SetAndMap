package com.EVG32.Initializating.employye.book.service.api;

import com.EVG32.Initializating.employye.book.domain.Employee;

public interface EmployeeService {

    String addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    String findEmployee(Employee employee);

    String printAllEmployees();
}
