package com.example.emptax.repository;

import com.example.emptax.model.CalculationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationDetailsRepository extends JpaRepository<CalculationDetails, Long> {
}
