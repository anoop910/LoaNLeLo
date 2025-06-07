package com.loanlelo.LoanLeLe.DTO.AdminLoanCreateDTO;

import lombok.Data;

@Data
public class GetAdminLoanType {
    private String name;
    private String subTitle;
    private Double interestRate;
    public GetAdminLoanType(String name, String subTitle, Double interestRate) {
        this.name = name;
        this.subTitle = subTitle;
        this.interestRate = interestRate;
    }

    
}
