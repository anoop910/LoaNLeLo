package com.loanlelo.LoanLeLe.DTO.BankDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateLoanByBank {

    @NotNull(message = "Loan name must not be null")
    @Size(min = 3, max = 100, message = "Loan name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Bank email must not be null")
    @Email(message = "Invalid email address format")
    private String bankEmail;

    @NotNull(message = "Loan subtitle must not be null")
    @Size(min = 5, max = 150, message = "Loan subtitle must be between 5 and 150 characters")
    private String subTitle;

    @NotNull(message = "Interest rate must not be null")
    @Positive(message = "Interest rate must be a positive number")
    private Double interestRate;

}
