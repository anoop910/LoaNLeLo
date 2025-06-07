package com.loanlelo.LoanLeLe.DTO.ConsumerDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class ConsumerCreate {
     @NotNull(message = "First name must not be null")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name must not be null")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Email must not be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message =  "Password must not be null")
    @Size(min=6, max= 15, message = "Address must be between 6 and 15 characters")
    private String password;
    @NotNull(message = "Phone number must not be null")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phone;

    // @NotNull(message = "Address must not be null")
    // @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    // private String address;

    // @NotNull(message = "Date of birth must not be null")
    // @Past(message = "Date of birth must be a past date")
    // private LocalDate dateOfBirth;

    // @NotNull(message = "City must not be null")
    // @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    // private String city;

    // @NotNull(message = "Zip code must not be null")
    // @Pattern(regexp = "^[0-9]{5,10}$", message = "Invalid zip code format")
    // private String zipCode;

    // @NotNull(message = "State must not be null")
    // @Size(min = 2, max = 50, message = "State must be between 2 and 50 characters")
    // private String state;

    // @NotNull(message = "Aadhaar number must not be null")
    // @Pattern(regexp = "^[0-9]{12}$", message = "Aadhaar number must be 12 digits")
    // private String aadharNumber;
}
