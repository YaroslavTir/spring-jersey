package com.yaroslavtir.server.repository;

import java.util.Arrays;
import java.util.List;

import com.yaroslavtir.server.exception.EmployeeAlreadyExists;
import com.yaroslavtir.server.exception.EmployeeNotFound;
import com.yaroslavtir.server.model.Employee;
import org.springframework.stereotype.Component;


@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> employeeList = Arrays.asList(
            new Employee(1, "Jane"),
            new Employee(2, "Jack"),
            new Employee(3, "George")
    );

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        throw new EmployeeNotFound();
    }

    public void updateEmployee(Employee employee, int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                emp.setId(employee.getId());
                emp.setFirstName(employee.getFirstName());
                return;
            }
        }
        throw new EmployeeNotFound();
    }

    public void deleteEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeList.remove(emp);
                return;
            }
        }
        throw new EmployeeNotFound();
    }

    public void addEmployee(Employee employee) {
        for (Employee emp : employeeList) {
            if (emp.getId() == employee.getId()) {
                throw new EmployeeAlreadyExists();
            }
        }
        employeeList.add(employee);
    }
}
