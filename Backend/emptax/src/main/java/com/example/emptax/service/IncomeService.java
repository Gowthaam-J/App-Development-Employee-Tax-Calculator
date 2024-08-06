package com.example.emptax.service;

import com.example.emptax.model.Income;
import com.example.emptax.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long incomeId) {
        return incomeRepository.findById(incomeId);
    }

    public Income updateIncome(Long incomeId, Income incomeDetails) {
        Optional<Income> optionalIncome = incomeRepository.findById(incomeId);
        if (optionalIncome.isPresent()) {
            Income income = optionalIncome.get();
            income.setDescription(incomeDetails.getDescription());
            return incomeRepository.save(income);
        }
        return null;
    }

    public void deleteIncomeById(Long incomeId) {
        incomeRepository.deleteById(incomeId);
    }
}
