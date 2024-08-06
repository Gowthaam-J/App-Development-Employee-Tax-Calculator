package com.example.emptax.controller;

import com.example.emptax.model.DeductionDetails;
import com.example.emptax.service.DeductionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deduction-details")
public class DeductionDetailsController {

    @Autowired
    private DeductionDetailsService deductionDetailsService;

    @PostMapping
    public ResponseEntity<DeductionDetails> createDeductionDetails(@RequestBody DeductionDetails deductionDetails) {
        DeductionDetails savedDeductionDetails = deductionDetailsService.saveDeductionDetails(deductionDetails);
        return ResponseEntity.ok(savedDeductionDetails);
    }

    @GetMapping
    public ResponseEntity<List<DeductionDetails>> getAllDeductionDetails() {
        List<DeductionDetails> deductionDetailsList = deductionDetailsService.getAllDeductionDetails();
        return ResponseEntity.ok(deductionDetailsList);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<DeductionDetails>> getDeductionDetailsByEmployeeId(@PathVariable Long employeeId) {
        List<DeductionDetails> deductionDetailsList = deductionDetailsService.getAllDeductionDetailsByEmployeeId(employeeId);
        return ResponseEntity.ok(deductionDetailsList);
    }
}
