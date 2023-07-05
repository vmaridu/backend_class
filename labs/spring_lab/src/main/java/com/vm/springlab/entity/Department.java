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
@Table("department")
public class Department implements Persistable {
    @Id
    @JsonProperty("uuid")
    private String uuid;

    @JsonIgnore
    @Transient
    private Boolean isNew;

    @JsonProperty("name")
    private String name;

    @JsonProperty("head")
    private String headUuid;

    @Override
    public Object getId() {
        return uuid;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
