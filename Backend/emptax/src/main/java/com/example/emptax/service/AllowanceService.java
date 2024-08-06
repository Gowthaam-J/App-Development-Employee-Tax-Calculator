package com.example.emptax.service;

import com.example.emptax.model.Allowance;
import com.example.emptax.repository.AllowanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllowanceService {

    @Autowired
    private AllowanceRepository allowanceRepository;

    public Allowance saveAllowance(Allowance allowance) {
        return allowanceRepository.save(allowance);
    }

    public List<Allowance> getAllAllowances() {
        return allowanceRepository.findAll();
    }

    public Optional<Allowance> getAllowanceById(Long allowanceId) {
        return allowanceRepository.findById(allowanceId);
    }

    public Allowance updateAllowance(Long allowanceId, Allowance allowanceDetails) {
        Optional<Allowance> optionalAllowance = allowanceRepository.findById(allowanceId);
        if (optionalAllowance.isPresent()) {
            Allowance allowance = optionalAllowance.get();
            allowance.setType(allowanceDetails.getType());
            allowance.setAmount(allowanceDetails.getAmount());
            allowance.setCompany(allowanceDetails.getCompany());
            return allowanceRepository.save(allowance);
        }
        return null;
    }

    public void deleteAllowanceById(Long allowanceId) {
        allowanceRepository.deleteById(allowanceId);
    }
}
