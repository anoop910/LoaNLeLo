package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;

import lombok.Data;

@Data
public class LoanCalculatedDaata {
    private Double totalPayment;
    private Double monthlyPayment;

    public LoanCalculatedDaata(double totalPayment, double monthlyPayment) {
        this.totalPayment = totalPayment;
        this.monthlyPayment = monthlyPayment;
    }

}
