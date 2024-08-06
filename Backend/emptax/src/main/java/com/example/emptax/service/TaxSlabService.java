package com.example.emptax.service;

import com.example.emptax.model.TaxSlab;
import com.example.emptax.repository.TaxSlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxSlabService {

    @Autowired
    private TaxSlabRepository taxSlabRepository;

    public TaxSlab saveTaxSlab(TaxSlab taxSlab) {
        return taxSlabRepository.save(taxSlab);
    }

    public List<TaxSlab> getAllTaxSlabs() {
        return taxSlabRepository.findAll();
    }

    public Optional<TaxSlab> getTaxSlabById(Long taxSlabId) {
        return taxSlabRepository.findById(taxSlabId);
    }

    public TaxSlab updateTaxSlab(Long taxSlabId, TaxSlab taxSlabDetails) {
        Optional<TaxSlab> optionalTaxSlab = taxSlabRepository.findById(taxSlabId);
        if (optionalTaxSlab.isPresent()) {
            TaxSlab taxSlab = optionalTaxSlab.get();
            taxSlab.setStartingAmount(taxSlabDetails.getStartingAmount());
            taxSlab.setEndingAmount(taxSlabDetails.getEndingAmount());
            taxSlab.setPercent(taxSlabDetails.getPercent());
            return taxSlabRepository.save(taxSlab);
        }
        return null;
    }

    public void deleteTaxSlabById(Long taxSlabId) {
        taxSlabRepository.deleteById(taxSlabId);
    }
    public void deleteTaxSlabByAll() {
        taxSlabRepository.deleteAll();;
    }
}
