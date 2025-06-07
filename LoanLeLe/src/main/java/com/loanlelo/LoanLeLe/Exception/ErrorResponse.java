package com.loanlelo.LoanLeLe.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String error;
    private List<String> messages;  // List of error messages
    private String path;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String error, String message, String path, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.messages = List.of(message);
        this.path = path;
        this.timestamp = timestamp;
    }
}
