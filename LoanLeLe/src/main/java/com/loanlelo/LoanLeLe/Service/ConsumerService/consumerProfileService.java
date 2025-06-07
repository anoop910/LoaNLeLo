package com.loanlelo.LoanLeLe.Service.ConsumerService;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumeProfileLoanData;
import com.loanlelo.LoanLeLe.Repository.LoanTakeByConsumerRepo;

@Service
public class consumerProfileService {
   private LoanTakeByConsumerRepo loanTakeByConsumerRepo;

   public consumerProfileService(LoanTakeByConsumerRepo loanTakeByConsumerRepo) {
    this.loanTakeByConsumerRepo = loanTakeByConsumerRepo;
   }

   

    public List<ConsumeProfileLoanData> consumerProfile(UserDetails userDetails) {
        String email = userDetails.getUsername();
        return loanTakeByConsumerRepo.makeComsuerProfile(email);

    }
}
