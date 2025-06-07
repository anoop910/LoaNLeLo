package com.loanlelo.LoanLeLe.Service.CompanyService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.CompanyRegister;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Repository.CompanyRepo;

@Service
public class CompanyCreateAndUpdate {
    private CompanyRepo companyRepo;

    public CompanyCreateAndUpdate(CompanyRepo companyRepo){
        this.companyRepo = companyRepo;
    }

    public CompanyRegister Register(CompanyRegister companyRegister){
        if (companyRegister != null) {
            Company company = new Company();
            company.setAddress(companyRegister.getAddress());
            company.setContactNumber(companyRegister.getContactNumber());
            company.setEmail(companyRegister.getEmail());
            company.setGstNumber(companyRegister.getGstNumber());
            company.setName(companyRegister.getName());
            company.setPassword(companyRegister.getPassword());

            companyRepo.save(company);
            return companyRegister;

        }
        return null;
    }

    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }

}
