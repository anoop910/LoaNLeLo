package com.loanlelo.LoanLeLe.Service.AdminService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest;
import com.loanlelo.LoanLeLe.Enum.CompanyRequest.Status;
import com.loanlelo.LoanLeLe.Repository.CompanyRepo;

@Service
public class AdminActionOnCompany {

    private CompanyRepo companyRepo;

    public AdminActionOnCompany(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<AdminSeeRequest> adminSeeRequest(){
        return companyRepo.findCompanyRequests();
    }
    @Transactional
    public Boolean adminApproveCompany(Long id){
        Status status = Status.APPROVED;
        companyRepo.adminApproveCompany(id, status);
        return true;
    }
    @Transactional
    public Boolean adminRejectCompanmyRequest(Long id, String rejectReason){
        Status status =Status.REJECTED;
        companyRepo.adminRejectCompany(id, status, rejectReason);
        return true;
    }

    
}
