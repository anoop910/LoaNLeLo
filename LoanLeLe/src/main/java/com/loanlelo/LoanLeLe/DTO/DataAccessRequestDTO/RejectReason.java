package com.loanlelo.LoanLeLe.DTO.DataAccessRequestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RejectReason {
    @NotBlank(message = "Reject reason cannot be blank")
    @Size(max = 255, message = "Reject reason cannot exceed 255 characters")
    private String rejectReason;
}
