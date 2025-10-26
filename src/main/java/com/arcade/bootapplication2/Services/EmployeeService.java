package com.arcade.bootapplication2.Services;

import com.arcade.bootapplication2.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(Long id);

    List<Employee> findAll();

    List<Employee> findByName(String name);

    Employee add(Employee employee);

    String removeById(Long id);
}
