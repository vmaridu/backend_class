package com.vm.springlab.repository.mem;

import com.vm.springlab.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DepartmentRepository {

    private final Map<String, Department> departments;

    public DepartmentRepository() {
        departments = new LinkedHashMap<>();
//        var hrDept = new Department(UUID.randomUUID().toString(), true, "HR", "Baby Maridu");
//        var itDept = new Department(UUID.randomUUID().toString(), true, "IT", "Teja Maridu");
//        var rdDept = new Department(UUID.randomUUID().toString(), true, "R&D", "Sudhu Maridu");
//        var accountsDept = new Department(UUID.randomUUID().toString(), true, "Accounts",
//                "Sai Maridu");
//        departments.put(hrDept.getUuid(), hrDept);
//        departments.put(itDept.getUuid(), itDept);
//        departments.put(rdDept.getUuid(), rdDept);
//        departments.put(accountsDept.getUuid(), accountsDept);
    }

    public List<Department> getDepartments() {

        return departments.values().stream().collect(Collectors.toList());
    }

    public Department getDepartment(String uuid) {
        if (!departments.containsKey(uuid)) {
            throw new RuntimeException("Department Not Found");
        }
        return departments.get(uuid);
    }

    public Department createDepartment(Department department) {
        if (department == null) {
            throw new RuntimeException("Department is empty");
        }
        department.setUuid(UUID.randomUUID().toString());
        departments.put(department.getUuid(), department);
        return department;
    }

    public Department editDepartment(String uuid, Department department) {
        if (!departments.containsKey(uuid)) {
            throw new RuntimeException("Department Not Found");
        }
        department.setUuid(uuid);
        departments.put(uuid, department);
        return department;
    }

    public Department deleteDepartment(String uuid) {
        if (!departments.containsKey(uuid)) {
            throw new RuntimeException("Department Not Found");
        }
        return departments.remove(uuid);
    }
}
