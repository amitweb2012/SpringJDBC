package org.springcore.dao;
import org.springcore.Employee;
import java.util.List;

public interface EmployeeDAO {
    int save(Employee employee);
    int update(Employee employee);
    int delete(int id);
    Employee getById(int id);
    List<Employee> getAll();
}
