package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.AdminLoanCreateDTO.GetAdminLoanType;
import com.loanlelo.LoanLeLe.DTO.BankDTO.BankEmail;
import com.loanlelo.LoanLeLe.Service.BankService.GetLoanTypeByBank;

@RestController
@RequestMapping("/admin")
public class GetLoanType {
    private GetLoanTypeByBank getLoanTypeByBank;

    public GetLoanType(GetLoanTypeByBank getLoanTypeByBank) {
        this.getLoanTypeByBank = getLoanTypeByBank;
    }
    
    @PostMapping("/view/loan")
    public List<GetAdminLoanType> bankLoanType(@RequestBody BankEmail bankEmail){
        return getLoanTypeByBank.getAdminLoanType(bankEmail);
    }
    
}
