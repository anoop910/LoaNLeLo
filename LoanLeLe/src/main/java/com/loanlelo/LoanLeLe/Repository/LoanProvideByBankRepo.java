package com.loanlelo.LoanLeLe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loanlelo.LoanLeLe.DTO.AdminLoanCreateDTO.GetAdminLoanType;
import com.loanlelo.LoanLeLe.Entity.LoanProvideByBank;

@Repository
public interface LoanProvideByBankRepo extends JpaRepository<LoanProvideByBank, Long> {

    @Query("SELECT new com.loanlelo.LoanLeLe.DTO.AdminLoanCreateDTO.GetAdminLoanType(l.name, l.subTitle, l.interestRate) "
            +
            "FROM LoanProvideByBank l " +
            "WHERE l.bank.email = :bankEmail")
    List<GetAdminLoanType> findLoanTypesByBankEmail(@Param("bankEmail") String bankEmail);

    

}
