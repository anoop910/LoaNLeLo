package com.loanlelo.LoanLeLe.Controller.CompanyAPI;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.CompanyRegister;
import com.loanlelo.LoanLeLe.DTO.CompanyDTO.CompanySeeConsumerData;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Service.CompanyService.CompanyCreateAndUpdate;
import com.loanlelo.LoanLeLe.Service.CompanyService.CompanySeeCounsumerData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyCreateAndUpdate companyCreateAndUpdate;
    private CompanySeeCounsumerData companySeeCounsumerData;

    

   

    public CompanyController(CompanyCreateAndUpdate companyCreateAndUpdate,
            CompanySeeCounsumerData companySeeCounsumerData) {
        this.companyCreateAndUpdate = companyCreateAndUpdate;
        this.companySeeCounsumerData = companySeeCounsumerData;
    }



    @PostMapping("/create")
    public CompanyRegister create(@Valid @RequestBody CompanyRegister companyRegister){
        return companyCreateAndUpdate.register(companyRegister);
    }
    @PreAuthorize("hasRole('ROLE_COMPANY')")
    @GetMapping("/view/consumer")
    public List<CompanySeeConsumerData> getCompanySeeConsumerDatas(@AuthenticationPrincipal UserDetails userDetails){
        return companySeeCounsumerData.companySeeConsumerData(userDetails);
    }
    
    @GetMapping
    public List<Company> getCompanys(){
        return companyCreateAndUpdate.getAllCompany();
    }

}