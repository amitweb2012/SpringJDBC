package org.springcore.service;
import org.springcore.Employee;
import org.springcore.dao.EmployeeDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public int addEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeDAO.update(employee);
    }

    public int deleteEmployee(int id) {
        return employeeDAO.delete(id);
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }
}
