package com.example.emptax.service;

import com.example.emptax.model.CalculationDetails;
import com.example.emptax.model.AllowanceDetails;
import com.example.emptax.model.DeductionDetails;
import com.example.emptax.model.IncomeDetails;
import com.example.emptax.repository.CalculationDetailsRepository;
import com.example.emptax.repository.AllowanceDetailsRepository;
import com.example.emptax.repository.DeductionDetailsRepository;
import com.example.emptax.repository.IncomeDetailsRepository;
import com.example.emptax.repository.TaxSlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculationDetailsService {

    @Autowired
    private CalculationDetailsRepository calculationDetailsRepository;

    @Autowired
    private AllowanceDetailsRepository allowanceDetailsRepository;

    @Autowired
    private DeductionDetailsRepository deductionDetailsRepository;

    @Autowired
    private IncomeDetailsRepository incomeDetailsRepository;

    @Autowired
    private TaxSlabRepository taxSlabRepository;

    public CalculationDetails saveCalculationDetails(CalculationDetails calculationDetails) {
        Long employeeId = calculationDetails.getEmployee().getEmployeeId();

        // Sum up the actual amounts for allowances, deductions, and income
        double totalAllowance = allowanceDetailsRepository.findByEmployeeId(employeeId)
                .stream().mapToDouble(AllowanceDetails::getGrantedAmount).sum();
        double totalDeduction = deductionDetailsRepository.findByEmployeeId(employeeId)
                .stream().mapToDouble(DeductionDetails::getDeductedAmount).sum();
        double totalIncome = incomeDetailsRepository.findByEmployeeId(employeeId)
                .stream().mapToDouble(IncomeDetails::getAmount).sum();

        calculationDetails.setTotalIncome(totalIncome);
        calculationDetails.setTotalAllowance(totalAllowance);
        calculationDetails.setTotalDeduction(totalDeduction);

        double grossSalary = totalIncome - totalAllowance;
        calculationDetails.setGrossSalary(grossSalary);

        double taxableIncome = grossSalary - totalDeduction;
        calculationDetails.setTaxableIncome(taxableIncome);

        // Calculate income tax based on tax slabs
        double incomeTax = taxSlabRepository.findAll().stream()
                .filter(taxSlab -> taxableIncome >= taxSlab.getStartingAmount() && taxableIncome <= taxSlab.getEndingAmount())
                .map(taxSlab -> taxableIncome * taxSlab.getPercent() / 100)
                .findFirst()
                .orElse(0.0);
        calculationDetails.setIncomeTax(incomeTax);

        return calculationDetailsRepository.save(calculationDetails);
    }

    public List<CalculationDetails> getAllCalculationDetails() {
        return calculationDetailsRepository.findAll();
    }

    public Optional<CalculationDetails> getCalculationDetailsById(Long calculationDetailsId) {
        return calculationDetailsRepository.findById(calculationDetailsId);
    }

    public CalculationDetails updateCalculationDetails(Long calculationDetailsId, CalculationDetails calculationDetails) {
        Optional<CalculationDetails> optionalCalculationDetails = calculationDetailsRepository.findById(calculationDetailsId);
        if (optionalCalculationDetails.isPresent()) {
            CalculationDetails existingCalculationDetails = optionalCalculationDetails.get();
            existingCalculationDetails.setEmployee(calculationDetails.getEmployee());
            existingCalculationDetails.setCompany(calculationDetails.getCompany());
            existingCalculationDetails.setTotalIncome(calculationDetails.getTotalIncome());
            existingCalculationDetails.setTotalAllowance(calculationDetails.getTotalAllowance());
            existingCalculationDetails.setTotalDeduction(calculationDetails.getTotalDeduction());
            existingCalculationDetails.setGrossSalary(calculationDetails.getGrossSalary());
            existingCalculationDetails.setTaxableIncome(calculationDetails.getTaxableIncome());
            existingCalculationDetails.setIncomeTax(calculationDetails.getIncomeTax());
            existingCalculationDetails.setStatus(calculationDetails.getStatus());
            return calculationDetailsRepository.save(existingCalculationDetails);
        }
        return null;
    }

    public void deleteCalculationDetailsById(Long calculationDetailsId) {
        calculationDetailsRepository.deleteById(calculationDetailsId);
    }
}
