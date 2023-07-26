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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("DEPARTMENT")
public class Department extends Entity {

    public Department(String uuid, String name, String headUuid) {
        super(uuid, null);
        this.name = name;
        this.headUuid = headUuid;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("head")
    private String headUuid;
}