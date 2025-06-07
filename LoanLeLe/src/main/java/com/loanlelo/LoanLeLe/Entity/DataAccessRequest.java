package com.loanlelo.LoanLeLe.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.loanlelo.LoanLeLe.Enum.DataAccessRequest.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class DataAccessRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private LocalDate requestDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING; // e.g., PENDING, APPROVED, REJECTED
    private String rejectReason;


    @ManyToOne
    @JsonBackReference
    private Company company;
}
