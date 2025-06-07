package com.loanlelo.LoanLeLe.Controller.ConsumerAPI;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumeProfileLoanData;
import com.loanlelo.LoanLeLe.Service.ConsumerService.consumerProfileService;

@RestController
@RequestMapping("/user")
public class ConsumerProfileController {
    private consumerProfileService profileService;

    public ConsumerProfileController(consumerProfileService profileService) {
        this.profileService = profileService;
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get/profile")
    public List<ConsumeProfileLoanData> cProfileData(@AuthenticationPrincipal UserDetails userDetails){
        return profileService.consumerProfile(userDetails);
    }
    
    
}
