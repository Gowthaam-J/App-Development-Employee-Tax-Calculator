package com.example.emptax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CalculationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calculationDetailsId;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private double totalIncome;
    private double totalAllowance;
    private double totalDeduction;
    private double grossSalary;
    private double taxableIncome;
    private double incomeTax;
    private String status;
}
