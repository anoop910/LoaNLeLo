package com.loanlelo.LoanLeLe.Service.CompanyService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest;
import com.loanlelo.LoanLeLe.DTO.DataAccessRequestDTO.CreateRquest;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Entity.DataAccessRequest;
import com.loanlelo.LoanLeLe.Repository.CompanyRepo;
import com.loanlelo.LoanLeLe.Repository.DataAccessRequestRepo;

@Service
public class DataAccessRequestService {
    private DataAccessRequestRepo dataAccessRequestRepo;
    private CompanyRepo companyRepo;


    public DataAccessRequestService(DataAccessRequestRepo dataAccessRequestRepo, CompanyRepo companyRepo){
        this.dataAccessRequestRepo = dataAccessRequestRepo;
        this.companyRepo = companyRepo;
    }

    public CreateRquest dataAccessRequestByCompany(Long id, CreateRquest createRquest){
        if (createRquest != null) {
            Company company = companyRepo.findById(id).orElseThrow(() -> new RuntimeException("Company not found: "+ id));
            DataAccessRequest newAccessRequest = new DataAccessRequest();
            newAccessRequest.setCompany(company);
            newAccessRequest.setReason(createRquest.getReason());
            newAccessRequest.setRequestDate(createRquest.getRequestDate());
            dataAccessRequestRepo.save(newAccessRequest);
            return createRquest;
        }
        return null;
    }

    public List<AdminSeeRequest> adminSeeRequest(){
        return dataAccessRequestRepo.getAllAdminSeeRequests();
    }

    


}
