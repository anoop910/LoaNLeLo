package com.loanlelo.LoanLeLe.DTO.BankDTO;

import lombok.Data;

@Data
public class GetBankByAdmin {
    private String name;
    private String licenseNumber;
    private String contactNumber;
    private String email;

    public GetBankByAdmin(String name, String licenseNumber, String contactNumber, String email) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    
}
