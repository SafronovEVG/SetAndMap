package com.EVG32.Initializating.employye.book.controller;

import com.EVG32.Initializating.employye.book.domain.Employee;
import com.EVG32.Initializating.employye.book.exception.EmployeeAlreadyAddedException;
import com.EVG32.Initializating.employye.book.exception.EmployeeNotFoundException;
import com.EVG32.Initializating.employye.book.exception.EmployeeStorageIsFullException;
import com.EVG32.Initializating.employye.book.service.api.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String name, @RequestParam String surname) {
        Employee employee = new Employee(name, surname);
        try {
            return employeeService.addEmployee(employee);
        } catch (EmployeeStorageIsFullException e) {
            return "Достигнуто максимальное количество сотрудников";
        } catch (EmployeeAlreadyAddedException e) {
            return "В списке уже есть этот сотрудникк";
        }
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String name, @RequestParam String surname) {
        Employee employee = new Employee(name, surname);
        try {
            employeeService.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден";
        }
        return employee + " Пользователь удален";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String name, @RequestParam String surname) {
        Employee employee = new Employee(name, surname);
        try {
            employeeService.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "Пользователь не найден";
        }
        return employeeService.findEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> all() {
        return employeeService.findAllEmployees();
    }
}
