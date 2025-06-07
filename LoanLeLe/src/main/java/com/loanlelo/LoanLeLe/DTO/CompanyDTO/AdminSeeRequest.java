package com.loanlelo.LoanLeLe.DTO.CompanyDTO;

import java.time.LocalDate;

import com.loanlelo.LoanLeLe.Enum.DataAccessRequest.Status;

import lombok.Data;

@Data
public class AdminSeeRequest {
    private String name;
    private String email;
    private Status status;
    private LocalDate requestDate;

    public AdminSeeRequest(String name, String email, LocalDate requestDate, Status status) {
        this.name = name;
        this.email = email;
        this.requestDate = requestDate;
        this.status = status;
    }

}
