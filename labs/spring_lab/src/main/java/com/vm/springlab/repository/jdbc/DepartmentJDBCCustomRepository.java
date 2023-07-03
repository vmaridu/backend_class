package com.vm.springlab.repository.jdbc;

import com.vm.springlab.entity.Department;
import com.vm.springlab.exception.ResourceExistsException;
import com.vm.springlab.exception.ResourceNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isNoneEmpty;

@Service
public class DepartmentJDBCCustomRepository {

    private static final String GET_DEPTS_QUERY = "SELECT * FROM DEPARTMENT";

    private static final String GET_DEPT_BY_UUID_QUERY = "SELECT * FROM DEPARTMENT WHERE UUID = ?";
    private static final String DELETE_DEPT_BY_UUID_QUERY = "DELETE FROM DEPARTMENT WHERE UUID = ?";
    private static final String UPDATE_DEPT_QUERY = "UPDATE DEPARTMENT SET NAME=?, HEAD_UUID=? WHERE UUID=?";
    private static final String INSERT_DEPT_QUERY = "INSERT INTO DEPARTMENT VALUES (?, ?, ?)";
    private static final String GET_DEPT_COUNT_BY_UUID_QUERY = "SELECT COUNT(UUID) FROM DEPARTMENT WHERE UUID = ?";
    private static final RowMapper<Department> ROW_MAPPER = (rs, rn) -> new Department(
            rs.getString("UUID"),
            rs.getString("NAME"),
            rs.getString("HEAD_UUID"));

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    @Autowired
    public DepartmentJDBCCustomRepository(DataSource dataSource, JdbcTemplate jdbcTemplate){
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("DEPARTMENT");
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean exists(String uuid){
        var count = jdbcTemplate.queryForObject(GET_DEPT_COUNT_BY_UUID_QUERY, Integer.class, uuid);
        return (count >= 1);
    }

    public List<Department> getDepartments() {
        return jdbcTemplate.query(GET_DEPTS_QUERY, ROW_MAPPER);
    }

    public Department getDepartmentInternal(String uuid) {
        if(exists(uuid)){
            return jdbcTemplate.queryForObject(GET_DEPT_BY_UUID_QUERY, ROW_MAPPER, uuid);
        }else {
            return null;
        }
    }

    public Department getDepartment(String uuid) {
        var department = getDepartmentInternal(uuid);
        if(department == null){
            throw new ResourceNotFoundException("404000", "uuid('%s') not found".formatted(uuid));
        }
        return department;
    }

    public Department createDepartment(Department dept) {
        var parameters = new HashMap<String, Object>();
        dept.setUuid(UUID.randomUUID().toString());
        parameters.put("uuid", dept.getUuid());
        parameters.put("name", dept.getName());
        parameters.put("head_uuid", dept.getHead());
        jdbcInsert.execute(parameters);
        return dept;
        //jdbcTemplate.update(INSERT_DEPT_QUERY, dept.getUuid(), dept.getName(), dept.getHead());
        // return dept;
        // var parameters = new HashMap<String, Object>();
        // dept.setUuid(UUID.randomUUID().toString());
        // parameters.put("uuid", dept.getUuid());
        // parameters.put("name", dept.getName());
        // parameters.put("head_uuid", dept.getHead());
        // jdbcInsert.execute(parameters);
        // var uuid = Optional.ofNullable(dept).map(d -> d.getUuid()).filter(id -> isNoneEmpty(id));
        // var isExist = uuid.map(id -> exists(id)).orElse(false);
        // if(isExist){
        //     throw new ResourceExistsException("409000", "uuid('%s') is already assigned to another resource".formatted(uuid.orElse("")));
        //
    }

    public Department editDepartment(String uuid, Department dept) {
        if(exists(uuid)){
            dept.setUuid(uuid);
            jdbcTemplate.update(UPDATE_DEPT_QUERY, dept.getName(), dept.getHead(), dept.getUuid());
            return dept;
        }else {
            throw new ResourceNotFoundException("404000", "uuid('%s') not found".formatted(uuid));
        }
    }

    public Department deleteDepartment(String uuid) {
        var department = getDepartmentInternal(uuid);
        if(department != null){
            jdbcTemplate.update(DELETE_DEPT_BY_UUID_QUERY, uuid);
            return department;
        }else {
            throw new ResourceNotFoundException("404000", "uuid(%s) not found".formatted(uuid));
        }
    }



}
