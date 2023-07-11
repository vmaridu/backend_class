package com.vm.springlab.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("employee")
public class Employee implements Persistable {

    @Id
    private String uuid;

    @Transient
    @JsonIgnore
    private Boolean isNew;

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

    @JsonProperty("verified")
    private Boolean verified;

    @Override
    @JsonIgnore
    public Object getId() {
        return uuid;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return isNew;
    }
}
