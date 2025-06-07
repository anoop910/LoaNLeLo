package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;

import java.time.LocalDate;

import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConsumerProfileData {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String homeAddress;
    private String city;
    private String state;
    private String zipCode;
    private LocalDate dateOfBirth;
    private String loanPurpose;
    private Double loanAmount;
    private double monthlyPayment;
    private double totalPayment;
    private Status status;
    private Double interestRate;
    private Integer loanTerm;

    public ConsumerProfileData(String firstName, String lastName, String email, String phone, String homeAddress,
            String city, String state, String zipCode, LocalDate dateOfBirth, String loanPurpose, Double loanAmount,
            Status status, Double interestRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.dateOfBirth = dateOfBirth;
        this.loanPurpose = loanPurpose;
        this.loanAmount = loanAmount;
        this.status = status;
        this.interestRate = interestRate;
    }

}
