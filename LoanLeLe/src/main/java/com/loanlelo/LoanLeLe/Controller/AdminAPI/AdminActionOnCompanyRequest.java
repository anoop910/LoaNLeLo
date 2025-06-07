package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.Service.CompanyService.DataAccessRequestAction;

@RestController
@RequestMapping("/admin")
public class AdminActionOnCompanyRequest {
    
    private DataAccessRequestAction dataAccessRequestAction;

    public AdminActionOnCompanyRequest(DataAccessRequestAction dataAccessRequestAction){
        this.dataAccessRequestAction = dataAccessRequestAction;
    }

    @PostMapping("/reject/{id}")
    public void requestRectject(@PathVariable Long id, @RequestBody String rejectReason){
        dataAccessRequestAction.dataAccessRequestRejectAction(id, rejectReason);
    }
    @PutMapping("/approve/{id}")
    public void requestApprove(@PathVariable Long id){
        dataAccessRequestAction.dataAccessRequestApproveAction(id);
    }

}
