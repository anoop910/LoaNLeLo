package com.loanlelo.LoanLeLe.DTO.DataAccessRequestDTO;

import java.time.LocalDate;

import lombok.Data;


@Data
public class CreateRquest {
    private String reason;
    private LocalDate requestDate;
}
