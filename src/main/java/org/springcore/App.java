package org.springcore;

import org.springcore.dao.EmployeeDAO;
import org.springcore.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setDepartment("IT");
        emp.setSalary(75000);

        employeeService.addEmployee(emp);
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDepartment() + " | " + e.getSalary());
        }
        context.close();
    }
}
