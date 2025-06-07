package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;


import java.time.LocalDate;

import lombok.Data;

@Data
public class ConsumerGetForLoan {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String homeAddress; 
    private String city;
    private String state;
    private String zipCode;
    private String aadharCardNumber; 
    private LocalDate dateOfBirth;
    public ConsumerGetForLoan(String firstName, String lastName, String email, String phone, String homeAddress,
            String city, String state, String zipCode, String aadharCardNumber, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.aadharCardNumber = aadharCardNumber;
        this.dateOfBirth = dateOfBirth;
     
    }
    
   
    

    

}
