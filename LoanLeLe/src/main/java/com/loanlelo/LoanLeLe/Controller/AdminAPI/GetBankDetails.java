package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.BankDTO.GetBankByAdmin;
import com.loanlelo.LoanLeLe.Service.BankService.BankRegisterAndUpdate;

@RestController
@RequestMapping("/admin")
public class GetBankDetails {

    private BankRegisterAndUpdate bankRegisterAndUpdate;

    public GetBankDetails(BankRegisterAndUpdate bankRegisterAndUpdate) {
        this.bankRegisterAndUpdate = bankRegisterAndUpdate;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/bank/details")
    public List<GetBankByAdmin> bankByAdmin(@AuthenticationPrincipal UserDetails userDetails) {
        return bankRegisterAndUpdate.getBankByAdmin(userDetails);
    }
}
