package com.example.emptax.controller;

import com.example.emptax.model.Income;
import com.example.emptax.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.saveIncome(income);
        return ResponseEntity.ok(savedIncome);
    }

    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomeList = incomeService.getAllIncomes();
        return ResponseEntity.ok(incomeList);
    }

    @GetMapping("/{incomeId}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long incomeId) {
        Optional<Income> income = incomeService.getIncomeById(incomeId);
        return income.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{incomeId}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long incomeId, @RequestBody Income incomeDetails) {
        Income updatedIncome = incomeService.updateIncome(incomeId, incomeDetails);
        return updatedIncome != null ? ResponseEntity.ok(updatedIncome) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{incomeId}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long incomeId) {
        incomeService.deleteIncomeById(incomeId);
        return ResponseEntity.noContent().build();
    }
}
