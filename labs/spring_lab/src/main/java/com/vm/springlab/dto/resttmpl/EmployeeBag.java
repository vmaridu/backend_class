package com.vm.springlab.dto.resttmpl;

import lombok.Data;

import java.util.Collection;

@Data
public class EmployeeBag {
    private String status;
    private Collection<Employee> data;
    private String message;
}
