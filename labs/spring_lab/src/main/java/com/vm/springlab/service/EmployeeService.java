package com.vm.springlab.service;

import com.vm.springlab.dto.EmployeeDeptDTO;
import com.vm.springlab.entity.Employee;
import com.vm.springlab.exception.BadRequestException;
import com.vm.springlab.exception.ResourceExistsException;
import com.vm.springlab.exception.ResourceNotFoundException;
import com.vm.springlab.repository.jdbc.EmployeeJDBCRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.*;


@Service
@Slf4j
public class EmployeeService {

    private final EmployeeJDBCRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeJDBCRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<EmployeeDeptDTO> getEmployeesByDepartment(String deptUuid) {

        List<EmployeeDeptDTO> objs = employeeRepository.findEmployeeDepartmentNames();
        objs.forEach(data -> log.info(data.toString()));

        // Finding all employees with department uuid
        // List<Object> objs = employeeRepository.findAllWithDepartment(deptUuid);
        // objs.forEach(data -> log.info(data.toString()));
        return objs;
    }

    public Employee getEmployee(String uuid) {
        return employeeRepository.findById(uuid).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        employee.setUuid(UUID.randomUUID().toString());
        /** No need to check
         if(isEmpty(employee.getUuid())){
         throw new BadRequestException("400000", "Employee Id cannot be empty");
         } **/
        if (employeeRepository.existsById(employee.getUuid())) {
            throw new ResourceExistsException("409000", "Employee exists with same Id");
        }
        employee.setIsNew(Boolean.TRUE);
        return employeeRepository.save(employee);
    }

    public Employee editEmployee(String uuid, Employee employee) {
        if (isEmpty(uuid)) {
            throw new BadRequestException("400000", "Employee Id cannot be empty");
        }
        if (!employeeRepository.existsById(uuid)) {
            throw new ResourceNotFoundException("404000", "Employee not found with Id");
        }
        employee.setIsNew(Boolean.FALSE);
        employee.setUuid(uuid);
        return employeeRepository.save(employee);
    }

    public String deleteEmployee(String uuid) {
        if (isEmpty(uuid)) {
            throw new BadRequestException("400000", "Employee Id cannot be empty");
        }
        if (!employeeRepository.existsById(uuid)) {
            throw new ResourceNotFoundException("404000", "Employee not found with Id");
        }
        employeeRepository.deleteById(uuid);
        return uuid;
    }
}
