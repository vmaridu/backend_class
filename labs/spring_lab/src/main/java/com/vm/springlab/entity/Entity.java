package com.vm.springlab.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity implements Persistable{

    @Id
    private String uuid;

    @Transient
    @JsonIgnore
    private Boolean isNew;

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