package com.example.emptax.repository;

import com.example.emptax.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.email = :email AND e.password = :password")
    Employee findByEmailAndPassword(String email, String password);
}
