package com.vm.spring_lab.service;

import com.vm.spring_lab.entity.Department;
import com.vm.spring_lab.repository.mem.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository deptRepository;

    @Autowired
    public DepartmentService(DepartmentRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    public List<Department> getDepartments() {
        return deptRepository.getDepartments();
    }

    public Department getDepartment(String uuid) {
        return deptRepository.getDepartment(uuid);
    }

    public Department createDepartment(Department dept) {
        return deptRepository.createDepartment(dept);
    }

    public Department editDepartment(String uuid, Department dept) {
        return deptRepository.editDepartment(uuid, dept);
    }

    public Department deleteDepartment(String uuid) {
        return deptRepository.deleteDepartment(uuid);
    }
}
