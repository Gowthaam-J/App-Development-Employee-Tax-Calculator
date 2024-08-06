package com.example.emptax.controller;

import com.example.emptax.model.IncomeDetails;
import com.example.emptax.service.IncomeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/income-details")
public class IncomeDetailsController {

    @Autowired
    private IncomeDetailsService incomeDetailsService;

    @PostMapping
    public ResponseEntity<IncomeDetails> createIncomeDetails(@RequestBody IncomeDetails incomeDetails) {
        IncomeDetails savedIncomeDetails = incomeDetailsService.saveIncomeDetails(incomeDetails);
        return ResponseEntity.ok(savedIncomeDetails);
    }

    @GetMapping
    public ResponseEntity<List<IncomeDetails>> getAllIncomeDetails() {
        List<IncomeDetails> incomeDetailsList = incomeDetailsService.getAllIncomeDetails();
        return ResponseEntity.ok(incomeDetailsList);
    }

    @GetMapping("/{incomeDetailsId}")
    public ResponseEntity<IncomeDetails> getIncomeDetailsById(@PathVariable Long incomeDetailsId) {
        Optional<IncomeDetails> incomeDetails = incomeDetailsService.getIncomeDetailsById(incomeDetailsId);
        return incomeDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<IncomeDetails>> getIncomeDetailsByEmployeeId(@PathVariable Long employeeId) {
        List<IncomeDetails> incomeDetailsList = incomeDetailsService.getIncomeDetailsByEmployeeId(employeeId);
        return ResponseEntity.ok(incomeDetailsList);
    }

    @GetMapping("/income/{incomeId}")
    public ResponseEntity<List<IncomeDetails>> getIncomeDetailsByIncomeId(@PathVariable Long incomeId) {
        List<IncomeDetails> incomeDetailsList = incomeDetailsService.getIncomeDetailsByIncomeId(incomeId);
        return ResponseEntity.ok(incomeDetailsList);
    }

    @PutMapping("/{incomeDetailsId}")
    public ResponseEntity<IncomeDetails> updateIncomeDetails(@PathVariable Long incomeDetailsId, @RequestBody IncomeDetails incomeDetails) {
        IncomeDetails updatedIncomeDetails = incomeDetailsService.updateIncomeDetails(incomeDetailsId, incomeDetails);
        return updatedIncomeDetails != null ? ResponseEntity.ok(updatedIncomeDetails) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{incomeDetailsId}")
    public ResponseEntity<Void> deleteIncomeDetails(@PathVariable Long incomeDetailsId) {
        incomeDetailsService.deleteIncomeDetailsById(incomeDetailsId);
        return ResponseEntity.noContent().build();
    }
}
