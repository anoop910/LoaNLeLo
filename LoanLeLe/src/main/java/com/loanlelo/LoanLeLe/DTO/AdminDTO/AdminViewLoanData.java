package com.loanlelo.LoanLeLe.DTO.AdminDTO;

import lombok.Data;

@Data
public class AdminViewLoanData {
    private String firstName;
    private String lastName;
    private String phone;
    private String homeAddress;
    private String aadharCardNumber;
    private String rejectReason;
    private String loanPurpose;
    private Double loanAmount;
    private Integer loanTerm;
    private String creditScoreRange;
    private Double annualIncome;
    public AdminViewLoanData(String firstName, String lastName, String phone, String homeAddress,
            String aadharCardNumber, String rejectReason, String loanPurpose, Double loanAmount, Integer loanTerm,
            String creditScoreRange, Double annualIncome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.aadharCardNumber = aadharCardNumber;
        this.rejectReason = rejectReason;
        this.loanPurpose = loanPurpose;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.creditScoreRange = creditScoreRange;
        this.annualIncome = annualIncome;
    }
    
}
