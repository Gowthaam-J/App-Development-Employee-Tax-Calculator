package com.example.emptax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.emptax.model.AllowanceDetails;

public interface AllowanceDetailsRepository extends JpaRepository<AllowanceDetails, Long> {
    @Query("select a from AllowanceDetails a where a.employee = :employeeId")
    List<AllowanceDetails> findByEmployeeId(Long employeeId);
}
