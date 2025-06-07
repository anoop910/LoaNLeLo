package com.loanlelo.LoanLeLe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loanlelo.LoanLeLe.DTO.BankDTO.GetBankByAdmin;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerSeeBank;
import com.loanlelo.LoanLeLe.Entity.Bank;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepo extends JpaRepository<Bank, Long> {
    Optional<Bank> findByEmail(String email);

    @Query("SELECT new com.loanlelo.LoanLeLe.DTO.BankDTO.GetBankByAdmin(b.name, b.licenseNumber, b.contactNumber, b.email) "
            +
            "FROM Bank b WHERE b.admin.email = :email")
    List<GetBankByAdmin> findBankDetailsByAdminEmail(@Param("email") String email);

    @Query("SELECT new com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerSeeBank(b.name, b.email) " +
            "FROM Bank b " +
            "WHERE b.id IN (SELECT lpb.bank.id FROM LoanProvideByBank lpb)")
    List<ConsumerSeeBank> findAllBanksProvidingLoans();

}