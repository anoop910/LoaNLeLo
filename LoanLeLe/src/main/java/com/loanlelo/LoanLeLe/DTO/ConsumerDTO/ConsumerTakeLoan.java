package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ConsumerTakeLoan {
    private String homeAddress;
    private String city;
    private String state;
    private String zipCode;
    private String aadharCardNumber;
    private LocalDate dateOfBirth;
    private String loanPurpose;
    private Double loanAmount;
    private Integer loanTerm;
    private String creditScoreRange;
    private Double annualIncome;
    private String employmentStatus;
    private Double monthlyDebtPayments;
    private Double interestRate;

}
