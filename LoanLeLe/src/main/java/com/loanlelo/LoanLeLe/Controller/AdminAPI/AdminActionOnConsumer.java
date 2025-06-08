package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminViewLoanData;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.AdminSeeConsumer;
import com.loanlelo.LoanLeLe.Service.ConsumerService.AdminTakeActionOnConsumerData;

@RestController
@RequestMapping("/admin")
public class AdminActionOnConsumer {
    private AdminTakeActionOnConsumerData adminTakeActionOnConsumerData;


    public AdminActionOnConsumer(AdminTakeActionOnConsumerData adminTakeActionOnConsumerData){
        this.adminTakeActionOnConsumerData = adminTakeActionOnConsumerData;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/loan/consumer")
    public List<AdminSeeConsumer> getAdminSeeConsumer(){
        return adminTakeActionOnConsumerData.adminSeeConsumer();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/loan/reject/{loanId}")
    public Boolean adminRejectLoan(@PathVariable Long loanId, @RequestBody String rejectReason){
        return adminTakeActionOnConsumerData.adminRejectLoan(loanId, rejectReason);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/loan/active/{loanId}")
    public Boolean adminActiveLoan(@PathVariable Long loanId){
        return adminTakeActionOnConsumerData.adminActiveLoan(loanId);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/view/loan/data/{id}")
     public Optional<AdminViewLoanData> adminViewData(@PathVariable Long id){
        return adminTakeActionOnConsumerData.adminViewLoanData(id);
     }

}
