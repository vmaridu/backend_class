package com.vm.springlab.controller;

import com.vm.springlab.entity.Department;
import com.vm.springlab.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/api/v1/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping(path = "/api/v1/departments/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department getDepartmentByUuid(@PathVariable String uuid) {
        return departmentService.getDepartment(uuid);
    }

    @PutMapping(path = "/api/v1/departments/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department editDepartment(@PathVariable String uuid, @RequestBody Department department) {
        return departmentService.editDepartment(uuid, department);
    }

    @PostMapping(path = "/api/v1/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @DeleteMapping(path = "/api/v1/departments/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteDepartmentByUuid(@PathVariable String uuid) {
        return departmentService.deleteDepartment(uuid);
    }
}

