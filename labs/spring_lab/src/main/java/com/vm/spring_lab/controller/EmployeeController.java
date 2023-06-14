package com.vm.spring_lab.controller;

import com.vm.spring_lab.entity.Employee;
import com.vm.spring_lab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/api/v1/employees/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable String uuid) {
        return employeeService.getEmployee(uuid);
    }

    @PutMapping(path = "/api/v1/employees/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee editEmployee(@PathVariable String uuid, @RequestBody Employee employee) {
        return employeeService.editEmployee(uuid, employee);
    }

    @PostMapping(path = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping(path = "/api/v1/employees/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee deleteEmployee(@PathVariable String uuid) {
        return employeeService.deleteEmployee(uuid);
    }

    // TODO: Write a Service for Verifying the employee
    // TODO: Write a Service for getting age, date of join information of employee
    // TODO: Naming conventions of different types of services, not CRED
    // TODO: Add extra response data, like HREF, etc
    // TODO: Exception handling 1. What kind of data response has, while any exception like "no data found",
    //  or "couldn't preformed action"
}
