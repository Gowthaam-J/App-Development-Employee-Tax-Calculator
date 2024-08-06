package com.example.emptax.repository;

import com.example.emptax.model.IncomeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDetailsRepository extends JpaRepository<IncomeDetails, Long> {
    @Query("select e from IncomeDetails e where e.employee_id=:employeeId")
    List<IncomeDetails> findByEmployeeId(Long employeeId);
    @Query("select e from IncomeDetails e where e.income_id =:incomeId")
    List<IncomeDetails> findByIncomeId(Long incomeId);
}
