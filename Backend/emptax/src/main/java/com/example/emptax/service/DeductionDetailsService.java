package com.example.emptax.service;

import com.example.emptax.model.Deduction;
import com.example.emptax.model.DeductionDetails;
import com.example.emptax.repository.DeductionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeductionDetailsService {

    @Autowired
    private DeductionDetailsRepository deductionDetailsRepository;

    @Autowired
    private DeductionService deductionService;

    public DeductionDetails saveDeductionDetails(DeductionDetails dd) {
        Long id = dd.getDeduction_id();
        Optional<Deduction> deduction = deductionService.getDeductionById(id);
        if (deduction.isPresent()) {
            Deduction act = deduction.get();
            Double amount = dd.getActualAmount() - act.getAmount();
            dd.setDeductedAmount(amount);
        }
        return deductionDetailsRepository.save(dd);
    }

    public List<DeductionDetails> getAllDeductionDetails() {
        return deductionDetailsRepository.findAll();
    }
    public List<DeductionDetails> getAllDeductionDetailsByEmployeeId(Long employeeId)
    {
        return deductionDetailsRepository.findByEmployeeId(employeeId);
    }
}

