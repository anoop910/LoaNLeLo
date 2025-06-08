package com.loanlelo.LoanLeLe.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Enum.CompanyRequest.Status;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
      Optional<Company> findByBusinessEmail(String email);

      @Query("SELECT c.status FROM Company c WHERE c.businessEmail = :email")
      Status findStatusByBusinessEmail(@Param("email") String email);

      @Transactional
      @Modifying
      @Query("UPDATE Company c SET c.status = :status, c.rejectReason = :rejectReason WHERE c.id = :id")
      int adminRejectCompany(@Param("id") Long id,
                  @Param("status") Status status,
                  @Param("rejectReason") String rejectReason);

      @Transactional
      @Modifying
      @Query("UPDATE Company c SET c.status = :status WHERE c.id = :id")
      int adminApproveCompany(@Param("id") Long id, @Param("status") Status status);

      @Query("SELECT new com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest(" +
                  "c.id, c.companyName, c.businessEmail, c.status, c.date, c.businessType) " +
                  "FROM Company c ")
      List<AdminSeeRequest> findCompanyRequests();

}
