package com.loanlelo.LoanLeLe.DTO.CompanyDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompanyRegister {
    @NotNull(message = "Name must not be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Email must not be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Password must not be null")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    private String password;

    @NotNull(message = "GST Number must not be null")
    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$", message = "Invalid GST number format")
    private String gstNumber;

    @NotNull(message = "Contact number must not be null")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Invalid contact number format")
    private String contactNumber;

    @NotNull(message = "Address must not be null")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    private String address;

}
