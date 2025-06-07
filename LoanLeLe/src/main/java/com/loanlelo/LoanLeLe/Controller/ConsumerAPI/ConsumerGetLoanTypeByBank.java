package com.loanlelo.LoanLeLe.Controller.ConsumerAPI;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.AdminLoanCreateDTO.GetAdminLoanType;
import com.loanlelo.LoanLeLe.DTO.BankDTO.BankEmail;
import com.loanlelo.LoanLeLe.Service.BankService.GetLoanTypeByBank;

@RestController
@RequestMapping("/loan")
public class ConsumerGetLoanTypeByBank {

    private GetLoanTypeByBank getLoanTypeByBank;

    public ConsumerGetLoanTypeByBank(GetLoanTypeByBank getLoanTypeByBank) {
        this.getLoanTypeByBank = getLoanTypeByBank;
    }


    @PostMapping("/type")
    public List<GetAdminLoanType> ConGetLoanTypeByBank(@RequestBody BankEmail email){
        return getLoanTypeByBank.getAdminLoanType(email);
    }
    
}
