package com.vm.springlab.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationProperties {

    // Getting property from Application.properties
    @Value("${employee.msg}")
    String employeeMsg;

}
