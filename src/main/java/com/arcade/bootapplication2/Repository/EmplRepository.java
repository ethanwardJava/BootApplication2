package com.arcade.bootapplication2.Repository;


import com.arcade.bootapplication2.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmplRepository extends JpaRepository<Employee , Long> {
    List<Employee> findEmployeeByLastName(String name);
}
