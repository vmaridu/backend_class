package com.vm.springlab.service;

import com.vm.springlab.dto.resttmpl.EmployeeBag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HttpBinClient {

    // TODO: consume rest api @ https://dummy.restapiexample.com/
    private final RestTemplate restTemplate;

    public HttpBinClient(){
        this.restTemplate = new RestTemplateBuilder().build();
        var result = getEmployeeBag();
        System.out.printf(result.getStatus());
    }
    
    public EmployeeBag getEmployeeBag(){
        var employeeBagEntity = restTemplate.getForEntity("https://dummy.restapiexample.com/api/v1/employees", EmployeeBag.class);
        log.info(employeeBagEntity.getHeaders().toString());
        return employeeBagEntity.getBody();
    }

    // call get

    // call get list

    // call post

    // call delete

    // call put

    // call patch
}
