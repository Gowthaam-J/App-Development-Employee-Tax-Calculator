package com.example.emptax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaxSlab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxSlabId;
    private double startingAmount;
    private double endingAmount;
    // private int taxPercentage;
    private int percent;
}
