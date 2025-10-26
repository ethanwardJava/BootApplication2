package com.arcade.bootapplication2.Services;


import com.arcade.bootapplication2.Exception.ResourceNotFoundException;
import com.arcade.bootapplication2.Entity.Employee;
import com.arcade.bootapplication2.Repository.EmplRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * EmplService handles the business logic for the {@link Employee}
 *
 * <p>Logging, performance tracking, and exception handling
 * are managed externally by AOP aspects for clean separation
 * of concerns.</p>
 *
 */

@Service
public class EmplService implements EmployeeService {
    private final EmplRepository emplRepository;

    public EmplService(EmplRepository emplRepository) {
        this.emplRepository = emplRepository;
    }

    /**
     * @return found entity
     * @throws ResourceNotFoundException when nothing was found
     * @Param id is the employees unique identifier in the DB
     */
    @Override
    public Employee findById(Long id) {
        return emplRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Employee with id %s not found", id)));
    }

    /**
     * Retrieves all students from the database.
     *
     * @return list of all {@link Employee} entities
     */
    @Override
    public List<Employee> findAll() {
        return emplRepository.findAll();
    }

    /**
     * @return found entity
     * @throws ResourceNotFoundException when nothing was found
     * @Param name will be return as a list , It may find more than one related name in the DB
     */
    @Override
    public List<Employee> findByName(String name) {
        return emplRepository.findEmployeeByLastName(name);
    }

    @Override
    public Employee add(Employee employee) {
        return emplRepository.save(employee);
    }

    @Override
    public String removeById(Long id) {
        emplRepository.deleteById(id);
        return "Employee with id " + id + " removed";
    }


}
