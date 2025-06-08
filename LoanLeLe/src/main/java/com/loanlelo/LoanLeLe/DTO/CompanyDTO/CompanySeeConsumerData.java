package com.loanlelo.LoanLeLe.DTO.CompanyDTO;

import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;

import lombok.Data;

@Data
public class CompanySeeConsumerData {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String loanPurpose;
    private Double loanAmount;
    private Status status;

    public CompanySeeConsumerData(String firstName, String lastName, String email, String phone, String loanPurpose,
            Double loanAmount, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.loanPurpose = loanPurpose;
        this.loanAmount = loanAmount;
        this.status = status;
    }

}
