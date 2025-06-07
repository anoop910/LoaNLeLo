package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;

import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;

import lombok.Data;

@Data
public class ConsumeProfileLoanData {
    private Double loanAmount;
    private Status status;
    private String loanPurpose;
    private Double interestRate;
    private Integer loanTerm;
    private Double monthlyPayment;

    public ConsumeProfileLoanData(Double loanAmount, Status status, String loanPurpose,
                                  Double interestRate, Integer loanTerm, Double monthlyPayment) {
        this.loanAmount = loanAmount;
        this.status = status;
        this.loanPurpose = loanPurpose;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.monthlyPayment = monthlyPayment;
    }
}

    
