package com.loanlelo.LoanLeLe.Entity;

import java.time.LocalDate;

import com.loanlelo.LoanLeLe.Enum.CompanyRequest.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String businessType;

    private String contactFirstName;

    private String contactLastName;

    @Column(unique = true)
    private String businessEmail;

    private String businessPhone;

    private String taxId;

    private String password;

    private String confirmPassword;

    private boolean termsAgreed;

    private Status status;

    private String rejectReason;

    private String role;

    private LocalDate date;

}
