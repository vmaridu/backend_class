package com.vm.springlab.repository.mem;

import com.vm.springlab.entity.Employee;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private final Map<String, Employee> employees;

    public EmployeeRepository() {
        employees = new LinkedHashMap<>();
        // uuid, first_ame, last_name, manager, salary, date_of_birth, joined_date_time, department_uuid
        var emp1 = new Employee(UUID.randomUUID().toString(), true, "Usha", "Bandham",
                BigDecimal.valueOf(25000),
                LocalDate.of(1995, Month.JANUARY, 1),
                LocalDateTime.of(2014, Month.JANUARY, 1, 11, 30, 30),
                UUID.randomUUID().toString(), "001");
        var emp2 = new Employee(UUID.randomUUID().toString(), true, "Raja", "Vab",
                BigDecimal.valueOf(55000),
                LocalDate.of(1996, Month.FEBRUARY, 13),
                LocalDateTime.of(2014, Month.JANUARY, 1, 8, 50, 50),
                UUID.randomUUID().toString(), "001");
        var emp3 = new Employee(UUID.randomUUID().toString(), true, "Srikanth", "R",
                BigDecimal.valueOf(35000),
                LocalDate.of(1994, Month.JANUARY, 1),
                LocalDateTime.of(2019, Month.MARCH, 1, 10, 20, 00),
                UUID.randomUUID().toString(), "001");
        var emp4 = new Employee(UUID.randomUUID().toString(), true, "Usha", "Bandham",
                BigDecimal.valueOf(29900),
                LocalDate.of(1998, Month.JANUARY, 1),
                LocalDateTime.of(2017, Month.JANUARY, 1, 12, 55, 45),
                UUID.randomUUID().toString(), "001");
        employees.put(emp1.getUuid(), emp1);
        employees.put(emp2.getUuid(), emp2);
        employees.put(emp3.getUuid(), emp3);
        employees.put(emp4.getUuid(), emp4);
    }

    public List<Employee> getEmployees() {
        return employees.values().stream().collect(Collectors.toList());
    }

    public Employee getEmployee(String uuid) {
        if (!employees.containsKey(uuid)) {
            throw new RuntimeException("Employee Not Found");
        }
        return employees.get(uuid);
    }

    public Employee createEmployee(Employee employee) {
        if (employee == null) {
            throw new RuntimeException("Employee is empty");
        }
        employee.setUuid(UUID.randomUUID().toString());
        employees.put(employee.getUuid(), employee);
        return employee;
    }

    public Employee editEmployee(String uuid, Employee employee) {
        if (!employees.containsKey(uuid)) {
            throw new RuntimeException("Employee Not Found");
        }
        employee.setUuid(uuid);
        employees.put(uuid, employee);
        return employee;
    }

    public Employee deleteEmployee(String uuid) {
        if (!employees.containsKey(uuid)) {
            throw new RuntimeException("Employee Not Found");
        }
        return employees.remove(uuid);
    }
}
