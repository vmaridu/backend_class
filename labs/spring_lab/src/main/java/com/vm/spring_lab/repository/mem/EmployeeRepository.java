package com.vm.spring_lab.repository.mem;

import com.vm.spring_lab.entity.Department;
import com.vm.spring_lab.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private final Map<String, Employee> employees;

    public EmployeeRepository() {
        employees = new LinkedHashMap<>();
        // uuid, first_ame, last_name, manager, salary, date_of_birth, joined_date_time, department_uuid
        Date dt = new Date();
        var emp1 = new Employee(UUID.randomUUID().toString(), "Usha", "Bandham", "Baby Maridu",
                80000.0, dt, dt, "001");
        var emp2 = new Employee(UUID.randomUUID().toString(), "Raja", "Vsa", "Baby Maridu",
                80000.0, dt, dt, "002");
        var emp3 = new Employee(UUID.randomUUID().toString(), "Srikanth", "Fdsa", "Teja Maridu",
                80000.0, dt, dt, "003");
        var emp4 = new Employee(UUID.randomUUID().toString(), "Hari", "Bssc", "Teja Maridu",
                80000.0, dt, dt, "004");
        var emp5 = new Employee(UUID.randomUUID().toString(), "Pooja", "Gfes", "Baby Maridu",
                80000.0, dt, dt, "005");
        employees.put(emp1.getUuid(), emp1);
        employees.put(emp2.getUuid(), emp2);
        employees.put(emp3.getUuid(), emp3);
        employees.put(emp4.getUuid(), emp4);
        employees.put(emp5.getUuid(), emp5);
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
