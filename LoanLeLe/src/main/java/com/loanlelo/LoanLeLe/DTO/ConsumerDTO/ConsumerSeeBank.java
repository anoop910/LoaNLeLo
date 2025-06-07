package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;

import lombok.Data;

@Data
public class ConsumerSeeBank {
    private String name;
    private String email;
    public ConsumerSeeBank(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
}
