package com.vm.springlab.service;

import com.vm.springlab.entity.Employee;
import com.vm.springlab.exception.BadRequestException;
import com.vm.springlab.exception.ResourceExistsException;
import com.vm.springlab.repository.jdbc.EmployeeJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeJDBCRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeJDBCRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        var result = new ArrayList<Employee>();
        for (Employee employee:employeeRepository.findAll()) {
            result.add(employee);
        }
        return result;
    }

    public Employee getEmployee(String uuid) {
        return employeeRepository.findById(uuid).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        var empUuid = employee.getUuid();

        if(isEmpty(empUuid)){
            throw new BadRequestException("400000", "emp id is empty");
        }

       if(employeeRepository.existsById(empUuid)){
           throw new ResourceExistsException("409000", "emp id is present");
       }

       return employeeRepository.save(employee);
    }

    public Employee editEmployee(String uuid, Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(String uuid) {

        if(isEmpty(uuid)){
            throw new BadRequestException("400000", "emp id is empty");
        }

        if(employeeRepository.existsById(uuid)){
            throw new ResourceExistsException("409000", "emp id is present");
        }

        employeeRepository.deleteById(uuid);
        return null;
    }

}
