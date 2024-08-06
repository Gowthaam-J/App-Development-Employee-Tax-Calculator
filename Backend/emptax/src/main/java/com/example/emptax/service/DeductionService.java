package com.example.emptax.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emptax.model.Deduction;
import com.example.emptax.repository.DeductionRepository;

@Service
public class DeductionService {
    @Autowired
    private DeductionRepository deductionRepository;

    public Deduction saveAllowance(Deduction deduction) {
        return deductionRepository.save(deduction);
    }

    public List<Deduction> getAllDeductions() {
        return deductionRepository.findAll();
    }

    public Optional<Deduction> getDeductionById(Long deductionId) {
        return deductionRepository.findById(deductionId);
    }

    public Deduction updateAllowance(Long deductionId, Deduction deductionDetails) {
        Optional<Deduction> optionaldeduction = deductionRepository.findById(deductionId);
        if (optionaldeduction.isPresent()) {
            Deduction deduction = optionaldeduction.get();
            deduction.setType(deductionDetails.getType());
            deduction.setAmount(deductionDetails.getAmount());
            deduction.setExpiryDate(deductionDetails.getExpiryDate());
            return deductionRepository.save(deduction);
        }
        return null;
    }

    public void deleteDeductionById(Long deductionId) {
        deductionRepository.deleteById(deductionId);
    }
}
