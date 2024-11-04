package com.EVG32.Initializating.employye.book.service.impl;

import com.EVG32.Initializating.employye.book.domain.Employee;
import com.EVG32.Initializating.employye.book.exception.EmployeeAlreadyAddedException;
import com.EVG32.Initializating.employye.book.exception.EmployeeNotFoundException;
import com.EVG32.Initializating.employye.book.exception.EmployeeStorageIsFullException;
import com.EVG32.Initializating.employye.book.service.api.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        int MAX_EMPLOYEES = 10;
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }

    }

    @Override
    public String printAllEmployees() {
       return employees.toString();
    }
}
