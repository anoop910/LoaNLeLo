package com.loanlelo.LoanLeLe.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Step 1: Personal Information
    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    private String email; 
    private String password;
    private String phone; 
    
    private String homeAddress; 
    private String city;
    private String state;
    private String zipCode;
    
    private String aadharCardNumber; 
    
    private LocalDate dateOfBirth; 
    
    private String role;


    

    // Relationship: Loans taken by the consumer
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "consumer")
    @JsonManagedReference
    private List<LoanTakenByConsumer> loanTakenByConsumer = new ArrayList<>();
}
