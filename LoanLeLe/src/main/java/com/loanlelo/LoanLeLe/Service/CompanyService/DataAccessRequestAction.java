package com.loanlelo.LoanLeLe.Service.CompanyService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.Enum.DataAccessRequest.Status;
import com.loanlelo.LoanLeLe.Repository.DataAccessRequestRepo;

@Service
public class DataAccessRequestAction {
    
    private DataAccessRequestRepo dataAccessRequestRepo;

    public DataAccessRequestAction(DataAccessRequestRepo dataAccessRequestRepo){
        this.dataAccessRequestRepo = dataAccessRequestRepo;
    }

    @Transactional
    public void dataAccessRequestRejectAction(Long id, String rejectReason){
        Status newStatus = Status.REJECTED;
        dataAccessRequestRepo.updateStatusAndRejectReason(id, newStatus, rejectReason);
    }

    @Transactional
    public void dataAccessRequestApproveAction(Long id){
        Status newStatus = Status.APPROVED;
        dataAccessRequestRepo.updateStatusById(id, newStatus);
    }


}
