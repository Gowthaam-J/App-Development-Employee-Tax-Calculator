package com.example.emptax.controller;

import com.example.emptax.model.Deduction;
import com.example.emptax.service.DeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deductions")
public class DeductionController {

    @Autowired
    private DeductionService deductionService;

    @PostMapping
    public ResponseEntity<Deduction> createDeduction(@RequestBody Deduction deduction) {
        Deduction savedDeduction = deductionService.saveAllowance(deduction);
        return ResponseEntity.ok(savedDeduction);
    }

    @GetMapping
    public ResponseEntity<List<Deduction>> getAllDeductions() {
        List<Deduction> deductions = deductionService.getAllDeductions();
        return ResponseEntity.ok(deductions);
    }

    @GetMapping("/{deductionId}")
    public ResponseEntity<Deduction> getDeductionById(@PathVariable Long deductionId) {
        Optional<Deduction> deduction = deductionService.getDeductionById(deductionId);
        return deduction.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{deductionId}")
    public ResponseEntity<Deduction> updateDeduction(@PathVariable Long deductionId, @RequestBody Deduction deductionDetails) {
        Deduction updatedDeduction = deductionService.updateAllowance(deductionId, deductionDetails);
        return updatedDeduction != null ? ResponseEntity.ok(updatedDeduction) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{deductionId}")
    public ResponseEntity<Void> deleteDeduction(@PathVariable Long deductionId) {
        deductionService.deleteDeductionById(deductionId);
        return ResponseEntity.noContent().build();
    }
}
