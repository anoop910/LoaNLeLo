package com.loanlelo.LoanLeLe.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanTakenByConsumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double interestRate;
    private Status status = Status.PENDING; // e.g., ACTIVE, CLOSED, DEFAULTED
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate dueDate;
    private Integer numberOfpaymentInstallments;
    private Double monthlyPayment; // Monthly EMI amount
    private Double totalPayment;
    private String rejectReason;
    private String loanPurpose;
    private Double loanAmount;
    private Integer loanTerm; 
    private String creditScoreRange;
    private Double annualIncome;
    private String employmentStatus;
    private Double monthlyDebtPayments;

    @ManyToOne
    @JsonBackReference
    private Consumer consumer;




}
