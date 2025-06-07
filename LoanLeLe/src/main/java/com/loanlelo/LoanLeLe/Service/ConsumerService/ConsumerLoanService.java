package com.loanlelo.LoanLeLe.Service.ConsumerService;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.type.descriptor.jdbc.LocalDateJdbcType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerTakeLoan;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.LoanCalculatedDaata;
import com.loanlelo.LoanLeLe.Entity.Consumer;
import com.loanlelo.LoanLeLe.Entity.LoanTakenByConsumer;
import com.loanlelo.LoanLeLe.LoanCalculatorService.LoanCalculator;
import com.loanlelo.LoanLeLe.Repository.ConsumerRepo;
import com.loanlelo.LoanLeLe.Repository.LoanTakeByConsumerRepo;

@Service
public class ConsumerLoanService {
    private LoanTakeByConsumerRepo loanTakenByConsumerRepo;
    private ConsumerRepo consumerRepo;

    public ConsumerLoanService(LoanTakeByConsumerRepo loanTakenByConsumerRepo, ConsumerRepo consumerRepo) {
        this.consumerRepo = consumerRepo;
        this.loanTakenByConsumerRepo = loanTakenByConsumerRepo;
    }

    @Transactional
    public Boolean TakeLoanbyConsumer(UserDetails userDetails, ConsumerTakeLoan consumerTakeLoan) {
        if (consumerTakeLoan != null) {
            String email = userDetails.getUsername();
            Consumer consumer = consumerRepo.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Consumer not found: " + email));
            LoanTakenByConsumer newlLoanTakenByConsumer = new LoanTakenByConsumer();

            newlLoanTakenByConsumer.setAnnualIncome(consumerTakeLoan.getAnnualIncome());
            newlLoanTakenByConsumer.setEmploymentStatus(consumerTakeLoan.getEmploymentStatus());
            newlLoanTakenByConsumer.setCreditScoreRange(consumerTakeLoan.getCreditScoreRange());
            newlLoanTakenByConsumer.setLoanAmount(consumerTakeLoan.getLoanAmount());
            newlLoanTakenByConsumer.setLoanPurpose(consumerTakeLoan.getLoanPurpose());
            newlLoanTakenByConsumer.setLoanTerm(consumerTakeLoan.getLoanTerm());
            newlLoanTakenByConsumer.setMonthlyDebtPayments(consumerTakeLoan.getMonthlyDebtPayments());
            newlLoanTakenByConsumer.setInterestRate(consumerTakeLoan.getInterestRate());
            consumer.setAadharCardNumber(consumerTakeLoan.getAadharCardNumber());
            consumer.setHomeAddress(consumerTakeLoan.getHomeAddress());
            consumer.setCity(consumerTakeLoan.getCity());
            consumer.setDateOfBirth(consumerTakeLoan.getDateOfBirth());
            consumer.setState(consumerTakeLoan.getState());
            consumer.setZipCode(consumerTakeLoan.getZipCode());
            LoanCalculator loanCalculator = new LoanCalculator();
            Double principal = consumerTakeLoan.getLoanAmount();
            Double interestRate = consumerTakeLoan.getInterestRate();
            Integer loanTerm = consumerTakeLoan.getLoanTerm();
            LoanCalculatedDaata calculatedDaata = loanCalculator.calculateLoanPayments(principal, interestRate,
                    loanTerm);
            newlLoanTakenByConsumer.setTotalPayment(calculatedDaata.getTotalPayment());
            newlLoanTakenByConsumer.setMonthlyPayment(calculatedDaata.getMonthlyPayment());
            LocalDate date = LocalDate.now();
            newlLoanTakenByConsumer.setStartDate(date);

            newlLoanTakenByConsumer.setConsumer(consumer);
            consumerRepo.save(consumer);
            loanTakenByConsumerRepo.save(newlLoanTakenByConsumer);
            return true;
        }
        return false;
    }
}
