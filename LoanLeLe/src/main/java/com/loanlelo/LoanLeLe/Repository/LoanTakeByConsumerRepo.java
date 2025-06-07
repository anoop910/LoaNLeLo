package com.loanlelo.LoanLeLe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumeProfileLoanData;
import com.loanlelo.LoanLeLe.Entity.LoanTakenByConsumer;
import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;

@Repository
public interface LoanTakeByConsumerRepo extends JpaRepository<LoanTakenByConsumer, Long> {

        @Modifying
        @Query("UPDATE LoanTakenByConsumer l SET l.status =:status WHERE l.id =:id")
        int adminActivedLoan(@Param("id") Long id, @Param("status") Status status);

        @Modifying
        @Transactional
        @Query("UPDATE LoanTakenByConsumer l " +
                        "SET l.status = :status, l.rejectReason = :rejectReason " +
                        "WHERE l.id = :id")
        int adminRejectLoan(@Param("id") Long id,
                        @Param("status") Status status,
                        @Param("rejectReason") String rejectReason);

        @Query("SELECT new com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumeProfileLoanData(l.loanAmount, l.status, l.loanPurpose, l.interestRate, l.loanTerm, l.monthlyPayment)"
                        + "FROM LoanTakenByConsumer l " + "JOIN l.consumer c" + " WHERE c.email =:email")
        List<ConsumeProfileLoanData> makeComsuerProfile(@Param("email") String email);
}
