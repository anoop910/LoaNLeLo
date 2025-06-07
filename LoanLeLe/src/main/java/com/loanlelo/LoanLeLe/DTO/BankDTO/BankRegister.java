package com.loanlelo.LoanLeLe.DTO.BankDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class BankRegister {

    @NotNull(message = "Bank name must not be null")
    @Size(min = 3, max = 100, message = "Bank name must be between 3 and 100 characters")
    private String name;
    
    @NotNull(message = "License number must not be null")
    @Size(min = 5, max = 50, message = "License number must be between 5 and 50 characters")
    private String licenseNumber;
    
    @NotNull(message = "Contact number must not be null")
    @Pattern(
        regexp = "^[+]?[0-9]{10,15}$",
        message = "Contact number must be a valid phone number with 10 to 15 digits"
    )
    private String contactNumber;
    
    @NotNull(message = "Email address must not be null")
    @Email(message = "Invalid email address format")
    private String email;
    
    @NotNull(message = "Address must not be null")
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    private String address;

}
