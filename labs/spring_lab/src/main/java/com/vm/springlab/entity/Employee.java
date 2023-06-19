package com.vm.springlab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String uuid;
    private String first_name;
    private String last_name;
    private String manager;
    private Double salary;
    private Date date_of_birth;
    private Date joined_date_time;
    private String department_uuid;
}
