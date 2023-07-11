package com.vm.springlab.repository.jdbc;

import com.vm.springlab.dto.EmployeeDeptDTO;
import com.vm.springlab.entity.Employee;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJDBCRepository extends CrudRepository<Employee, String> {

    @Query("SELECT e.*,d.* FROM employee e " +
            "JOIN department d ON e.department_uuid = d.uuid " +
            "WHERE e.department_uuid = :deptUuid")
    List<Object> findAllWithDepartment(String deptUuid);

    //TODO: Needs fixing, employee_last_name is not setting to lastName in EmployeeDeptDTO
    @Query("""
            SELECT e.uuid as uuid,
                   e.first_name as first_name,
                   e.last_name as employee_last_name,
                   e.department_uuid as department_uuid,
                   d.name as department_name
            FROM employee e
            JOIN department d ON e.department_uuid = d.uuid 
            WHERE e.department_uuid = :deptUuid 
            """)
    List<EmployeeDeptDTO> findEmployeeDepartmentNames(String deptUuid);

    @Modifying
    @Query("UPDATE employee e SET e.verified = :status " +
            "WHERE e.uuid = :empUuid")
    void changeEmployeeVerifiedStatus(String empUuid, Boolean status);

}
