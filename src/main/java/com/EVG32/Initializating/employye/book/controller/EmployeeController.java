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

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "add")
    public String addEmployee(@RequestParam("name") String name,
                              @RequestParam("surname") String surname) {
        Employee employee = new Employee(name, surname);
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeStorageIsFullException e) {
            return "Достигнуто максимальное количество сотрудников";
        } catch (EmployeeAlreadyAddedException e) {
            return "В списке уже есть этот сотрудникк";
        }
        return employee + " Cоздан";
    }

    @GetMapping(path = "remove")
    public String removeEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Employee employee = new Employee(name, surname);
        try {
            employeeService.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден";
        }
        return employee + " Пользователь удален";
    }

    @GetMapping(path = "find")
    public String findEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        Employee employee = new Employee(name, surname);
        try {
            employeeService.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return ("Пользователь не найден");
        }
        return employee + " Найден";
    }

    @GetMapping(path = "all")
    public String all() {
        return employeeService.printAllEmployees();
    }
}
