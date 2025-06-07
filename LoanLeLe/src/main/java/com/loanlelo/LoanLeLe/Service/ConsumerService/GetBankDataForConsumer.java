package com.loanlelo.LoanLeLe.Service.ConsumerService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerSeeBank;
import com.loanlelo.LoanLeLe.Repository.BankRepo;

@Service
public class GetBankDataForConsumer {
    
    private BankRepo bankRepo;

    public GetBankDataForConsumer(BankRepo bankRepo) {
        this.bankRepo = bankRepo;
    }


    public List<ConsumerSeeBank> getallbBanks(){
        return bankRepo.findAllBanksProvidingLoans();
    }

    
}
