package com.example.emptax.service;

import com.example.emptax.model.Allowance;
import com.example.emptax.model.AllowanceDetails;
import com.example.emptax.repository.AllowanceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllowanceDetailsService {

    @Autowired
    private AllowanceDetailsRepository allowanceDetailsRepository;

    @Autowired
    private AllowanceService allowanceService;

    public AllowanceDetails saveAllowanceDetails(AllowanceDetails ad) {
        Long id = ad.getAllowance_id();
        Optional<Allowance> allowance = allowanceService.getAllowanceById(id);
        if (allowance.isPresent()) {
            Allowance act = allowance.get();
            Double amount = ad.getActualAmount() - act.getAmount();
            ad.setGrantedAmount(amount);
        }
        return allowanceDetailsRepository.save(ad);
    }

    public List<AllowanceDetails> getAllAllowanceDetails() {
        return allowanceDetailsRepository.findAll();
    }

    public List<AllowanceDetails> getAllAllowanceDetailsByEmployeeId(Long employeeId) {
        return allowanceDetailsRepository.findByEmployeeId(employeeId);
    }
    public void deleteById(Long id)
    {
        allowanceDetailsRepository.deleteById(id);
    }
}
