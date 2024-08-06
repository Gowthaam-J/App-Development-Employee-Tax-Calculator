package com.example.emptax.controller;

import com.example.emptax.model.CalculationDetails;
import com.example.emptax.service.CalculationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calculationDetails")
public class CalculationDetailsController {

    @Autowired
    private CalculationDetailsService calculationDetailsService;

    // Create a new CalculationDetails
    @PostMapping
    public ResponseEntity<CalculationDetails> createCalculationDetails(@RequestBody CalculationDetails calculationDetails) {
        CalculationDetails savedCalculationDetails = calculationDetailsService.saveCalculationDetails(calculationDetails);
        return ResponseEntity.ok(savedCalculationDetails);
    }

    // Get all CalculationDetails
    @GetMapping
    public ResponseEntity<List<CalculationDetails>> getAllCalculationDetails() {
        List<CalculationDetails> calculationDetailsList = calculationDetailsService.getAllCalculationDetails();
        return ResponseEntity.ok(calculationDetailsList);
    }

    // Get CalculationDetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<CalculationDetails> getCalculationDetailsById(@PathVariable Long id) {
        Optional<CalculationDetails> calculationDetails = calculationDetailsService.getCalculationDetailsById(id);
        if (calculationDetails.isPresent()) {
            return ResponseEntity.ok(calculationDetails.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update CalculationDetails
    @PutMapping("/{id}")
    public ResponseEntity<CalculationDetails> updateCalculationDetails(
            @PathVariable Long id,
            @RequestBody CalculationDetails calculationDetails) {
        CalculationDetails updatedCalculationDetails = calculationDetailsService.updateCalculationDetails(id, calculationDetails);
        if (updatedCalculationDetails != null) {
            return ResponseEntity.ok(updatedCalculationDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete CalculationDetails by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalculationDetails(@PathVariable Long id) {
        calculationDetailsService.deleteCalculationDetailsById(id);
        return ResponseEntity.noContent().build();
    }
}
