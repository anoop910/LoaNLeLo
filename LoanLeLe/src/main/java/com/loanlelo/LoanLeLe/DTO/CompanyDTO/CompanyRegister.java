package com.loanlelo.LoanLeLe.DTO.CompanyDTO;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class CompanyRegister {

    @NotBlank(message = "Company name is required.")
    @Size(max = 255, message = "Company name cannot exceed 255 characters.")
    private String companyName;

    @Size(max = 255, message = "Business type cannot exceed 255 characters.")
    private String businessType;

    @NotBlank(message = "Contact first name is required.")
    @Size(max = 255, message = "Contact first name cannot exceed 255 characters.")
    private String contactFirstName;

    @NotBlank(message = "Contact last name is required.")
    @Size(max = 255, message = "Contact last name cannot exceed 255 characters.")
    private String contactLastName;

    @NotBlank(message = "Business email is required.")
    @Email(message = "Please provide a valid email address.")
    @Size(max = 255, message = "Business email cannot exceed 255 characters.")
    private String businessEmail;

    @NotBlank(message = "Business phone is required.")
    @Pattern(regexp = "^[0-9+\\-() ]+$", message = "Business phone must contain only valid phone characters.")
    @Size(max = 255, message = "Business phone cannot exceed 255 characters.")
    private String businessPhone;

    @NotBlank(message = "Tax ID is required.")
    @Size(max = 255, message = "Tax ID cannot exceed 255 characters.")
    private String taxId;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    @Size(min = 8, max = 64, message = "Confirm password must be between 8 and 64 characters.")
    private String confirmPassword;

    @AssertTrue(message = "You must agree to the terms and conditions.")
    private boolean termsAgreed;

}
