package com.example.emptax.service;

import com.example.emptax.model.IncomeDetails;
import com.example.emptax.repository.IncomeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeDetailsService {

    @Autowired
    private IncomeDetailsRepository incomeDetailsRepository;

    public IncomeDetails saveIncomeDetails(IncomeDetails incomeDetails) {
        return incomeDetailsRepository.save(incomeDetails);
    }

    public List<IncomeDetails> getAllIncomeDetails() {
        return incomeDetailsRepository.findAll();
    }

    public Optional<IncomeDetails> getIncomeDetailsById(Long incomeDetailsId) {
        return incomeDetailsRepository.findById(incomeDetailsId);
    }

    public List<IncomeDetails> getIncomeDetailsByEmployeeId(Long employeeId) {
        return incomeDetailsRepository.findByEmployeeId(employeeId);
    }

    public List<IncomeDetails> getIncomeDetailsByIncomeId(Long incomeId) {
        return incomeDetailsRepository.findByIncomeId(incomeId);
    }

    public IncomeDetails updateIncomeDetails(Long incomeDetailsId, IncomeDetails incomeDetails) {
        Optional<IncomeDetails> optionalIncomeDetails = incomeDetailsRepository.findById(incomeDetailsId);
        if (optionalIncomeDetails.isPresent()) {
            IncomeDetails existingIncomeDetails = optionalIncomeDetails.get();
            existingIncomeDetails.setEmployee_id(incomeDetails.getEmployee_id());
            existingIncomeDetails.setIncome_id(incomeDetails.getIncome_id());
            existingIncomeDetails.setAmount(incomeDetails.getAmount());
            return incomeDetailsRepository.save(existingIncomeDetails);
        }
        return null;
    }

    public void deleteIncomeDetailsById(Long incomeDetailsId) {
        incomeDetailsRepository.deleteById(incomeDetailsId);
    }
}
