package com.example.emptax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.emptax.model.DeductionDetails;

public interface DeductionDetailsRepository extends JpaRepository<DeductionDetails,Long>{
      @Query("select e from DeductionDetails e where e.employee_id=:employeeId")
    List<DeductionDetails> findByEmployeeId(Long employeeId);
}
