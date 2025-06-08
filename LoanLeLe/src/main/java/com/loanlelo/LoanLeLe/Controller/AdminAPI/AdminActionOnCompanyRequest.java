package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest;
import com.loanlelo.LoanLeLe.Service.AdminService.AdminActionOnCompany;

@RestController
@RequestMapping("/admin")
public class AdminActionOnCompanyRequest {

    private AdminActionOnCompany actionOnCompany;

    public AdminActionOnCompanyRequest(AdminActionOnCompany actionOnCompany) {
        this.actionOnCompany = actionOnCompany;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/view/company")
    public List<AdminSeeRequest> getAdminSeeRequest() {
        return actionOnCompany.adminSeeRequest();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/approve/company/{id}")
    public Boolean ApproveComanyByAdmin(@PathVariable Long id){
        return actionOnCompany.adminApproveCompany(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/reject/company/{id}")
    public Boolean ApproveComanyByAdmin(@PathVariable Long id, @RequestBody String rejectReason){
        return actionOnCompany.adminRejectCompanmyRequest(id, rejectReason);
    }

}
