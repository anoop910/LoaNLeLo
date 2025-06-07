package com.loanlelo.LoanLeLe.Service.BankService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.AdminLoanCreateDTO.GetAdminLoanType;
import com.loanlelo.LoanLeLe.DTO.BankDTO.BankEmail;
import com.loanlelo.LoanLeLe.Repository.LoanProvideByBankRepo;

@Service
public class GetLoanTypeByBank {
    private LoanProvideByBankRepo loanProvideByBankRepo;

    public GetLoanTypeByBank(LoanProvideByBankRepo loanProvideByBankRepo) {
        this.loanProvideByBankRepo = loanProvideByBankRepo;
    }
    

    public List<GetAdminLoanType> getAdminLoanType(BankEmail email){
        String newEmail = email.getEmail();
        return loanProvideByBankRepo.findLoanTypesByBankEmail(newEmail);
    }
}
