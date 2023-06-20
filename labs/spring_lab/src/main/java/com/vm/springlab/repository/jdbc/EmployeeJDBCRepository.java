package com.vm.springlab.repository.jdbc;

import com.vm.springlab.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeJDBCRepository extends CrudRepository<Employee, String> {

}
