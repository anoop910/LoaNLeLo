package com.loanlelo.LoanLeLe.Service.CompanyService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.CompanyRegister;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Enum.CompanyRequest.Status;
import com.loanlelo.LoanLeLe.Repository.CompanyRepo;

@Service
public class CompanyCreateAndUpdate {
    private CompanyRepo companyRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyCreateAndUpdate(CompanyRepo companyRepo){
        this.companyRepo = companyRepo;
    }
   @Transactional
    public CompanyRegister register(CompanyRegister companyRegister) {
        if (companyRegister == null) {
            return null;
        }

        // Optional: Validate password confirmation
        if (!companyRegister.getPassword().equals(companyRegister.getConfirmPassword())) {
            throw new IllegalArgumentException("Password and Confirm Password do not match.");
        }

        // Map DTO to Entity
        Company company = new Company();
        company.setCompanyName(companyRegister.getCompanyName());
        company.setBusinessType(companyRegister.getBusinessType());
        company.setContactFirstName(companyRegister.getContactFirstName());
        company.setContactLastName(companyRegister.getContactLastName());
        company.setBusinessEmail(companyRegister.getBusinessEmail());
        company.setBusinessPhone(companyRegister.getBusinessPhone());
        company.setTaxId(companyRegister.getTaxId());
        
        Status status = Status.PENDING;

        company.setStatus(status);
        String role = "ROLE_COMPANY";
        company.setRole(role);
        LocalDate date = LocalDate.now();
        company.setDate(date);
        

        // You probably want to hash the password before saving it (not shown here)
        company.setPassword(passwordEncoder.encode(companyRegister.getPassword()));

        companyRepo.save(company);

        // You can also consider returning some entity or DTO with saved ID if needed
        return companyRegister;
    }

    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }

}
