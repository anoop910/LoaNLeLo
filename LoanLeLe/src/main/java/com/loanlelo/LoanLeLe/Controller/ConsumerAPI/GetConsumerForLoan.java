package com.loanlelo.LoanLeLe.Controller.ConsumerAPI;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerGetForLoan;
import com.loanlelo.LoanLeLe.Service.ConsumerService.ConsumerCreateAndUpdate;

@RestController
@RequestMapping("/user")
public class GetConsumerForLoan {
    private ConsumerCreateAndUpdate consumerCreateAndUpdate;

    
    public GetConsumerForLoan(ConsumerCreateAndUpdate consumerCreateAndUpdate) {
        this.consumerCreateAndUpdate = consumerCreateAndUpdate;
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get/data")
    public ConsumerGetForLoan getForLoan(@AuthenticationPrincipal UserDetails userDetails){
        return consumerCreateAndUpdate.getConsumer(userDetails);
    }
}
