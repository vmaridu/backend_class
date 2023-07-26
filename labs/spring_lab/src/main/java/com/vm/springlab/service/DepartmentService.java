package com.vm.springlab.service;

import com.vm.springlab.entity.Department;
import com.vm.springlab.exception.BadRequestException;
import com.vm.springlab.exception.ResourceExistsException;
import com.vm.springlab.exception.ResourceNotFoundException;
import com.vm.springlab.repository.jdbc.DepartmentJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class DepartmentService {

    private final DepartmentJDBCRepository deptRepository;

    @Autowired
    public DepartmentService(DepartmentJDBCRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    public List<Department> getDepartments() {
        return (List<Department>) deptRepository.findAll();
    }

    public Department getDepartment(String uuid) {
        return deptRepository.findById(uuid).orElse(null);
    }

    public Department createDepartment(Department dept) {
        var empUuid = dept.getUuid();
        if(isEmpty(empUuid)){
            throw new BadRequestException("400000", "Department Id cannot be empty");
        }
        if(deptRepository.existsById(empUuid)){
            throw new ResourceExistsException("409000", "Department exists with same Id");
        }
        dept.setIsNew(Boolean.TRUE);
        return deptRepository.save(dept);
    }

    public Department editDepartment(String uuid, Department dept) {
        if(isEmpty(uuid)){
            throw new BadRequestException("400000", "Department Id cannot be empty");
        }
        if(!deptRepository.existsById(uuid)){
            throw new ResourceNotFoundException("404000", "Department not found with Id");
        }
        dept.setIsNew(Boolean.FALSE);
        dept.setUuid(uuid);
        return deptRepository.save(dept);
    }

    public String deleteDepartment(String uuid) {
        if(isEmpty(uuid)) {
            throw new BadRequestException("400000", "Department Id cannot be empty");
        }
        if(!deptRepository.existsById(uuid)) {
            throw new ResourceNotFoundException("404000", "Department not found with Id");
        }
        deptRepository.deleteById(uuid);
        return uuid;
    }
}