package com.yaroslavtir.server.repository;

import com.yaroslavtir.server.model.Employee;

import java.util.List;


public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    void updateEmployee(Employee employee, int id);

    void deleteEmployee(int id);

    void addEmployee(Employee employee);
}
