package com.loanlelo.LoanLeLe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest;
import com.loanlelo.LoanLeLe.Entity.DataAccessRequest;
import com.loanlelo.LoanLeLe.Enum.DataAccessRequest.Status;

@Repository
public interface DataAccessRequestRepo extends JpaRepository<DataAccessRequest, Long> {

    @Query("SELECT new com.loanlelo.LoanLeLe.DTO.CompanyDTO.AdminSeeRequest(c.name, c.email, d.requestDate, d.status) "
            +
            "FROM DataAccessRequest d " +
            "JOIN d.company c")
    List<AdminSeeRequest> getAllAdminSeeRequests();

    @Modifying
    @Query("UPDATE DataAccessRequest d " +
            "SET d.status = :status, d.rejectReason = :rejectReason " +
            "WHERE d.id = :id")
    int updateStatusAndRejectReason(@Param("id") Long id,
            @Param("status") Status status,
            @Param("rejectReason") String rejectReason);

    @Modifying
    @Query("UPDATE DataAccessRequest d SET d.status = :status WHERE d.id = :id")
    int updateStatusById(@Param("id") Long id, @Param("status") Status status);
}
