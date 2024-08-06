package com.example.emptax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emptax.model.Deduction;

public interface DeductionRepository extends JpaRepository<Deduction,Long>{

    
} 
