package com.example.emptax.controller;

import com.example.emptax.model.Company;
import com.example.emptax.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyId, @RequestBody Company companyDetails) {
        Company updatedCompany = companyService.updateCompany(companyId, companyDetails);
        return updatedCompany != null ? ResponseEntity.ok(updatedCompany) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        Optional<Company> company = companyService.getCompanyById(companyId);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<Company> getCompanyByCidAndGstin(@RequestParam Long cid, @RequestParam Long gstin) {
        Company company = companyService.getCompanyByCidAndGstin(cid, gstin);
        return company != null ? ResponseEntity.ok(company) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompanyById(companyId);
        return ResponseEntity.noContent().build();
    }
}
