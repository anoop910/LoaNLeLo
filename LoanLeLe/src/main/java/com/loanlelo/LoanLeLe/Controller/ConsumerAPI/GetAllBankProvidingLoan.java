package com.loanlelo.LoanLeLe.Controller.ConsumerAPI;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerSeeBank;
import com.loanlelo.LoanLeLe.Service.ConsumerService.GetBankDataForConsumer;

@RestController
@RequestMapping("/all/bank/providing")
public class GetAllBankProvidingLoan {
    private GetBankDataForConsumer getBankDataForConsumer;

    public GetAllBankProvidingLoan(GetBankDataForConsumer getBankDataForConsumer) {
        this.getBankDataForConsumer = getBankDataForConsumer;
    }

    
    @GetMapping("/loan")
    private List<ConsumerSeeBank> bankProvidingLoan() {
        return getBankDataForConsumer.getallbBanks();
    }
}
