package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.BankDTO.BankRegister;
import com.loanlelo.LoanLeLe.DTO.BankDTO.CreateLoanByBank;
import com.loanlelo.LoanLeLe.Entity.Bank;
import com.loanlelo.LoanLeLe.Service.BankService.BankRegisterAndUpdate;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/bank")
public class BankRegisterController {
    private BankRegisterAndUpdate bankRegisterAndUpdate;

    public BankRegisterController(BankRegisterAndUpdate bankRegisterAndUpdate){
        this.bankRegisterAndUpdate = bankRegisterAndUpdate;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public BankRegister registerBank(@Valid @RequestBody BankRegister bankRegister, @AuthenticationPrincipal UserDetails userDetails){
        
        return bankRegisterAndUpdate.createBank(bankRegister, userDetails);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create/loan")
    public CreateLoanByBank createLoan(@Valid @RequestBody CreateLoanByBank createLoanByBank){
        return bankRegisterAndUpdate.createLoanByBank(createLoanByBank);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Bank> getBanks(){
        return bankRegisterAndUpdate.getAllbank();
    }

    
}
