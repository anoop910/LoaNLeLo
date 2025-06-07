package com.loanlelo.LoanLeLe.Controller.ConsumerAPI;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerCreate;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerTakeLoan;
import com.loanlelo.LoanLeLe.Entity.Consumer;
import com.loanlelo.LoanLeLe.Service.ConsumerService.ConsumerCreateAndUpdate;
import com.loanlelo.LoanLeLe.Service.ConsumerService.ConsumerLoanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class ConsumerController {

    private ConsumerCreateAndUpdate consumerCreateAndUpdate;
    private ConsumerLoanService consumerLoanService;


    public ConsumerController(ConsumerCreateAndUpdate consumerCreateAndUpdate, ConsumerLoanService consumerLoanService){
        this.consumerCreateAndUpdate = consumerCreateAndUpdate;
        this.consumerLoanService = consumerLoanService;
    }
    @PostMapping("/create")
    public ConsumerCreate create(@Valid @RequestBody ConsumerCreate consumerCreate){
        return consumerCreateAndUpdate.createConsumer(consumerCreate);
    }
    

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get")    
    public List<Consumer> getConsumers(){
        return consumerCreateAndUpdate.getAllConsumer();
    }
     @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/take/loan")
    public Boolean TakeLoan(@AuthenticationPrincipal UserDetails userDetails, @RequestBody ConsumerTakeLoan consumerTakeLoan){
        return  consumerLoanService.TakeLoanbyConsumer(userDetails, consumerTakeLoan);
    }
    
}
