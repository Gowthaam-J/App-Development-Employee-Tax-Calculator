package com.example.emptax.model;

import jakarta.persistence.Column;
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
public class DeductionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deductionDetailsId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee_id;

    @Column(nullable = false)
    private long deduction_id;

    private double actualAmount;
    private double deductedAmount;
}
