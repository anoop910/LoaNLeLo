package com.loanlelo.LoanLeLe.DTO.CompanyDTO;

import java.time.LocalDate;

import com.loanlelo.LoanLeLe.Enum.CompanyRequest.Status;

import lombok.Data;

@Data
public class AdminSeeRequest {
   private Long id;
   private String companyName;
   private String businessEmail;
   private Status status;
   private LocalDate date;
   private String businessType;
   public AdminSeeRequest(Long id, String companyName, String businessEmail, Status status, LocalDate date,
         String businessType) {
      this.id = id;
      this.companyName = companyName;
      this.businessEmail = businessEmail;
      this.status = status;
      this.date = date;
      this.businessType = businessType;
   }
   

}
