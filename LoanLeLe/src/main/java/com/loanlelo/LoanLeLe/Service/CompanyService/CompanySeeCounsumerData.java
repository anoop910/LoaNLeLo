package com.loanlelo.LoanLeLe.Service.CompanyService;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.CompanySeeConsumerData;
import com.loanlelo.LoanLeLe.Enum.CompanyRequest.Status;
import com.loanlelo.LoanLeLe.Repository.CompanyRepo;
import com.loanlelo.LoanLeLe.Repository.LoanTakeByConsumerRepo;

@Service
public class CompanySeeCounsumerData {
    private CompanyRepo companyRepo;

    private LoanTakeByConsumerRepo loanTakeByConsumerRepo;

    public CompanySeeCounsumerData(CompanyRepo companyRepo, LoanTakeByConsumerRepo loanTakeByConsumerRepo) {
        this.companyRepo = companyRepo;
        this.loanTakeByConsumerRepo = loanTakeByConsumerRepo;
    }

    public List<CompanySeeConsumerData> companySeeConsumerData(UserDetails userDetails){
        String email = userDetails.getUsername();

        Status status = companyRepo.findStatusByBusinessEmail(email);
        if (status == Status.APPROVED) {
           return loanTakeByConsumerRepo.companySeeConsumerData();
        }
        return null;
    }

}
