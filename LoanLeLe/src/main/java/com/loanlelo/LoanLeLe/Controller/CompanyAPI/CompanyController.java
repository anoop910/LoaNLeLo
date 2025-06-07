package com.loanlelo.LoanLeLe.Controller.CompanyAPI;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest;
import com.loanlelo.LoanLeLe.DTO.CompanyDTO.CompanyRegister;
import com.loanlelo.LoanLeLe.DTO.DataAccessRequestDTO.CreateRquest;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Service.CompanyService.CompanyCreateAndUpdate;
import com.loanlelo.LoanLeLe.Service.CompanyService.DataAccessRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyCreateAndUpdate companyCreateAndUpdate;
    private DataAccessRequestService dataAccessRequestService;

    public CompanyController(CompanyCreateAndUpdate companyCreateAndUpdate, DataAccessRequestService dataAccessRequestService){
        this.companyCreateAndUpdate = companyCreateAndUpdate;
        this.dataAccessRequestService = dataAccessRequestService;
    }

    @PostMapping("/create")
    public CompanyRegister create(@Valid @RequestBody CompanyRegister companyRegister){
        return companyCreateAndUpdate.Register(companyRegister);
    }
    
    
    @GetMapping
    public List<Company> getCompanys(){
        return companyCreateAndUpdate.getAllCompany();
    }

    @GetMapping("/getrequest")
    public List<AdminSeeRequest> getRequests(){
        return dataAccessRequestService.adminSeeRequest();
    }

    @PostMapping("/request/{id}")
    public CreateRquest createRquest(@PathVariable Long id, @RequestBody CreateRquest createRquest){
        return dataAccessRequestService.dataAccessRequestByCompany(id, createRquest);
    }
}