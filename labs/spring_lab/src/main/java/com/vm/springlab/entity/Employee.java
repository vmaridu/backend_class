package com.vm.springlab.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("EMPLOYEE")
public class Employee extends Entity {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private BigDecimal salary;

    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @JsonProperty("joined_date_time")
    private LocalDateTime joinedDateTime;

    @JsonProperty("department_uuid")
    private String departmentUuid;

    @JsonProperty("manager_uuid")
    private String managerUuid;

    /*
        @JsonProperty("verified")
    private Boolean verified;
     */


}