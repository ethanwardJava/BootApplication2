package com.arcade.bootapplication2.Controller;

import com.arcade.bootapplication2.Entity.Employee;
import com.arcade.bootapplication2.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ===========================  ONE EMPLOYEE VIA UNIQUE ADDRESS  ==============================
    @GetMapping("/id/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    // ===========================  ALL THE EMPLOYEES IN THE DATA BASE  ===========================
    @GetMapping("/all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // ===========================  LIST OF EMPLOYEES VIA SAME NAME ================================
    @GetMapping("/name/{name}")
    public List<Employee> findByName(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    // ===========================  ADDING A NEW EMPLOYEE (HAS VALIDATION) =========================
    @PostMapping
    public Employee save(@Valid @RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    // ===========================  REMOVE EMPLOYEE BASED ON A UNIQUE ID ===========================
    public String deleteById(@PathVariable Long id) {
        employeeService.removeById(id);
        return "REMOVING ...";
    }

}
