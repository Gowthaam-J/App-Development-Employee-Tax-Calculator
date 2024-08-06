package com.example.emptax.controller;

import com.example.emptax.model.AllowanceDetails;
import com.example.emptax.service.AllowanceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allowance-details")
public class AllowanceDetailsController {

    @Autowired
    private AllowanceDetailsService allowanceDetailsService;

    @PostMapping
    public ResponseEntity<AllowanceDetails> createAllowanceDetails(@RequestBody AllowanceDetails allowanceDetails) {
        AllowanceDetails savedAllowanceDetails = allowanceDetailsService.saveAllowanceDetails(allowanceDetails);
        return new ResponseEntity<>(savedAllowanceDetails, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllowanceDetails> getAllowanceDetailsById(@PathVariable("id") Long id) {
        return allowanceDetailsService.getAllAllowanceDetails().stream()
                .filter(ad -> ad.getAllowanceDetailsId().equals(id))
                .findFirst()
                .map(allowanceDetails -> new ResponseEntity<>(allowanceDetails, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AllowanceDetails>> getAllowanceDetailsByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        List<AllowanceDetails> allowanceDetailsList = allowanceDetailsService.getAllAllowanceDetailsByEmployeeId(employeeId);
        return new ResponseEntity<>(allowanceDetailsList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AllowanceDetails>> getAllAllowanceDetails() {
        List<AllowanceDetails> allowanceDetailsList = allowanceDetailsService.getAllAllowanceDetails();
        return new ResponseEntity<>(allowanceDetailsList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AllowanceDetails> updateAllowanceDetails(@PathVariable("id") Long id,
                                                                   @RequestBody AllowanceDetails allowanceDetails) {
        AllowanceDetails existingAllowanceDetails = allowanceDetailsService.getAllAllowanceDetails().stream()
                .filter(ad -> ad.getAllowanceDetailsId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingAllowanceDetails != null) {
            allowanceDetails.setAllowanceDetailsId(id);
            AllowanceDetails updatedAllowanceDetails = allowanceDetailsService.saveAllowanceDetails(allowanceDetails);
            return new ResponseEntity<>(updatedAllowanceDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllowanceDetails(@PathVariable("id") Long id) {
        AllowanceDetails existingAllowanceDetails = allowanceDetailsService.getAllAllowanceDetails().stream()
                .filter(ad -> ad.getAllowanceDetailsId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingAllowanceDetails != null) {
            allowanceDetailsService.getAllAllowanceDetails().remove(existingAllowanceDetails);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
