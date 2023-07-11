package com.vm.springlab.controller;

import com.vm.springlab.config.ApplicationProperties;
import com.vm.springlab.dto.EmployeeDeptDTO;
import com.vm.springlab.entity.Employee;
import com.vm.springlab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              ApplicationProperties appProps) {
        System.out.println(appProps.getEmployeeMsg());
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        List<Employee> lst = employeeService.getEmployees();
        return lst;
    }

    @GetMapping(path = "/api/v1/departments/{deptUuid}/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDeptDTO> getEmployeesByDepartment(@PathVariable String deptUuid) {
        return employeeService.getEmployeesByDepartment(deptUuid);
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
    public String deleteEmployee(@PathVariable String uuid) {
        return employeeService.deleteEmployee(uuid);
    }


    @PutMapping(path = "/api/v1/employees/{uuid}/verify", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean verifyEmployee(@PathVariable String uuid) {
        return employeeService.verifiedEmployee(uuid);
    }

    // TODO: Write a Service for Verifying the employee
    // TODO: Write a Service for getting age, date of join information of employee
    // TODO: Naming conventions of different types of services, not CRED
    // TODO: Add extra response data, like HREF, etc
    // TODO: Exception handling 1. What kind of data response has, while any exception like "no data found",
    //  or "couldn't preformed action"
}
