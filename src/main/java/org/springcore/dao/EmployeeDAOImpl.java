package org.springcore.dao;

import org.springcore.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Employee employee) {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary());
    }

    @Override
    public int update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getSalary(), employee.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
}
