package com.vm.springlab.service;

import com.vm.springlab.entity.Department;
import com.vm.springlab.repository.jdbc.DepartmentJDBCCustomRepository;
import com.vm.springlab.repository.mem.DepartmentMemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentJDBCCustomRepository deptRepository;

    @Autowired
    public DepartmentService(DepartmentJDBCCustomRepository deptRepository) {
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
