package com.loanlelo.LoanLeLe.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminViewLoanData;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.AdminSeeConsumer;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerGetForLoan;
import com.loanlelo.LoanLeLe.Entity.Consumer;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, Long> {

        @Query("SELECT new com.loanlelo.LoanLeLe.DTO.ConsumerDTO.AdminSeeConsumer(c.firstName, c.lastName, c.email, l.id, l.loanAmount, l.status, l.startDate )"
                        + "FROM Consumer c " + "JOIN c.loanTakenByConsumer l")
        List<AdminSeeConsumer> adminSeeConsumers();

        Optional<Consumer> findByEmail(String email);

        @Query("SELECT new com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerGetForLoan(c.firstName, c.lastName, c.email, c.phone, c.homeAddress, c.city, c.state, c.zipCode, c.aadharCardNumber, c.dateOfBirth) "
                        +
                        "FROM Consumer c WHERE c.email = :email")
        Optional<ConsumerGetForLoan> findConsumerGetForLoanByEmail(@Param("email") String email);

        // @Query("SELECT new
        // com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumeProfileLoanData(l.loanAmount,
        // l.status, l.loanPurpose, l.interestRate, l.loanTerm)"
        // + "FROM Consumer c " + "JOIN c.loanTakenByConsumer l" + " WHERE c.email =
        // :email")
        // List<ConsumeProfileLoanData> makeComsuerProfile(@Param("email") String
        // email);

        @Query("SELECT new com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminViewLoanData(" +
                        "c.firstName, " +
                        "c.lastName, " +
                        "c.phone, " +
                        "c.homeAddress, " +
                        "c.aadharCardNumber, " +
                        "l.rejectReason, " +
                        "l.loanPurpose, " +
                        "l.loanAmount, " +
                        "l.loanTerm, " +
                        "l.creditScoreRange, " +
                        "l.annualIncome) " +
                        "FROM Consumer c " +
                        "JOIN c.loanTakenByConsumer l " +
                        "WHERE l.id =:id")
        Optional<AdminViewLoanData> fetchLoanDetailsById(@Param("id") Long id);

}
