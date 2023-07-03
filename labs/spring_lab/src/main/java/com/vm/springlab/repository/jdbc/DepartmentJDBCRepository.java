package com.vm.springlab.repository.jdbc;

import com.vm.springlab.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentJDBCRepository extends CrudRepository<Department, String> {

}
