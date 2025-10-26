package com.arcade.bootapplication2.Controller;

import com.arcade.bootapplication2.Entity.Employee;
import com.arcade.bootapplication2.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/id/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/all")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Employee> findByName(@PathVariable String name){
        return employeeService.findByName(name);
    }
}
