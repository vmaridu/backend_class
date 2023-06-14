package com.vm.spring_lab.service;

import com.vm.spring_lab.entity.Department;
import com.vm.spring_lab.entity.Employee;
import com.vm.spring_lab.repository.mem.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee getEmployee(String uuid) {
        return employeeRepository.getEmployee(uuid);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee editEmployee(String uuid, Employee employee) {
        return employeeRepository.editEmployee(uuid, employee);
    }

    public Employee deleteEmployee(String uuid) {
        return employeeRepository.deleteEmployee(uuid);
    }

}
