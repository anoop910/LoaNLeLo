package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;

import java.time.LocalDate;

import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;

import lombok.Data;

@Data
public class AdminSeeConsumer {
    private String firstName;
    private String lastName;
    private String email;
    private Long id;
    private Double loanAmount;
    private Status status;
    private LocalDate startDate;
   

    public AdminSeeConsumer(String firstName, String lastName, String email, Long id, Double loanAmount, Status status,
         LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.loanAmount = loanAmount;
        this.status = status;
        this.startDate = startDate;

    }

   
    

}
