package com.loanlelo.LoanLeLe.LoanCalculatorService;

import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.LoanCalculatedDaata;
@Service
public class LoanCalculator {

    /**
     * Calculates the monthly and total payment for a loan.
     * 
     * @param principal The total amount borrowed (principal).
     * @param annualInterestRate The annual interest rate as a percentage (e.g., 5.5 for 5.5%).
     * @param loanTermMonths The loan term in months.
     * @return An array where index 0 is the monthly payment and index 1 is the total payment.
     */
    public LoanCalculatedDaata calculateLoanPayments(Double principal, Double annualInterestRate, Integer loanTermMonths) {
        Double monthlyInterestRate = annualInterestRate / 100 / 12;
        Integer numberOfPayments = loanTermMonths;

        Double monthlyPayment;
        if (monthlyInterestRate == 0) {
            // No interest loan
            monthlyPayment = principal / numberOfPayments;
        } else {
            // Monthly Payment = [P * r * (1 + r)^n] / [(1 + r)^n - 1]
            monthlyPayment = (principal * monthlyInterestRate *
                    Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                    (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        }

        Double totalPayment = monthlyPayment * numberOfPayments;

        return new LoanCalculatedDaata(totalPayment, monthlyPayment);
    }

}