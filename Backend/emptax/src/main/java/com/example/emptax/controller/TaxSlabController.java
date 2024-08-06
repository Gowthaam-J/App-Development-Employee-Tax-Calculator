package com.example.emptax.controller;

import com.example.emptax.model.TaxSlab;
import com.example.emptax.service.TaxSlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taxslabs")
public class TaxSlabController {

    @Autowired
    private TaxSlabService taxSlabService;

    @PostMapping
    public ResponseEntity<TaxSlab> createTaxSlab(@RequestBody TaxSlab taxSlab) {
        TaxSlab savedTaxSlab = taxSlabService.saveTaxSlab(taxSlab);
        // System.out.println(taxSlab.get());
        return ResponseEntity.ok(savedTaxSlab);
    }

    @PutMapping("/{taxSlabId}")
    public ResponseEntity<TaxSlab> updateTaxSlab(@PathVariable Long taxSlabId, @RequestBody TaxSlab taxSlabDetails) {
        TaxSlab updatedTaxSlab = taxSlabService.updateTaxSlab(taxSlabId, taxSlabDetails);
        return updatedTaxSlab != null ? ResponseEntity.ok(updatedTaxSlab) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{taxSlabId}")
    public ResponseEntity<TaxSlab> getTaxSlabById(@PathVariable Long taxSlabId) {
        Optional<TaxSlab> taxSlab = taxSlabService.getTaxSlabById(taxSlabId);
        return taxSlab.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TaxSlab>> getAllTaxSlabs() {
        List<TaxSlab> taxSlabs = taxSlabService.getAllTaxSlabs();
        return ResponseEntity.ok(taxSlabs);
    }

    @DeleteMapping("/{taxSlabId}")
    public ResponseEntity<Void> deleteTaxSlab(@PathVariable Long taxSlabId) {
        taxSlabService.deleteTaxSlabById(taxSlabId);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteTaxSlabAll() {
        taxSlabService.deleteTaxSlabByAll();
        return ResponseEntity.noContent().build();
    }

}
