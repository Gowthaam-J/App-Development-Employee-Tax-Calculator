package com.example.emptax.controller;

import com.example.emptax.model.Allowance;
import com.example.emptax.service.AllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/allowances")
public class AllowanceController {

    @Autowired
    private AllowanceService allowanceService;

    @PostMapping
    public ResponseEntity<Allowance> createAllowance(@RequestBody Allowance allowance) {
        Allowance savedAllowance = allowanceService.saveAllowance(allowance);
        return ResponseEntity.ok(savedAllowance);
    }

    @GetMapping
    public ResponseEntity<List<Allowance>> getAllAllowances() {
        List<Allowance> allowances = allowanceService.getAllAllowances();
        return ResponseEntity.ok(allowances);
    }

    @GetMapping("/{allowanceId}")
    public ResponseEntity<Allowance> getAllowanceById(@PathVariable Long allowanceId) {
        Optional<Allowance> allowance = allowanceService.getAllowanceById(allowanceId);
        return allowance.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{allowanceId}")
    public ResponseEntity<Allowance> updateAllowance(@PathVariable Long allowanceId, @RequestBody Allowance allowanceDetails) {
        Allowance updatedAllowance = allowanceService.updateAllowance(allowanceId, allowanceDetails);
        return updatedAllowance != null ? ResponseEntity.ok(updatedAllowance) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{allowanceId}")
    public ResponseEntity<Void> deleteAllowance(@PathVariable Long allowanceId) {
        allowanceService.deleteAllowanceById(allowanceId);
        return ResponseEntity.noContent().build();
    }
}
