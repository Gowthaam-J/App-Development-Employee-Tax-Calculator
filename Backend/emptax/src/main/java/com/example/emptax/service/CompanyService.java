package com.example.emptax.service;

import com.example.emptax.model.Company;
import com.example.emptax.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long companyId, Company companyDetails) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setCompanyName(companyDetails.getCompanyName());
            company.setGstin(companyDetails.getGstin());
            company.setCid(companyDetails.getCid());
            company.setDescription(companyDetails.getDescription());
            return companyRepository.save(company);
        }
        return null;
    }

    public Company getCompanyByCidAndGstin(Long cid, Long gstin) {
        return companyRepository.findByCidAndGstin(cid, gstin);
    }
    public Optional<Company> getCompanyById(Long company_id){
        return companyRepository.findById(company_id);
    }

    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
