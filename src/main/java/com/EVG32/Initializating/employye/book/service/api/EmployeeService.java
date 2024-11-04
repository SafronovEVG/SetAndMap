package com.EVG32.Initializating.employye.book.service.api;

import com.EVG32.Initializating.employye.book.domain.Employee;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    String printAllEmployees();
}
