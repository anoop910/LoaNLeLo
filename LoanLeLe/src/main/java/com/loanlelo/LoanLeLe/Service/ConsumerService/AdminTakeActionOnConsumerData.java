package com.loanlelo.LoanLeLe.Service.ConsumerService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminViewLoanData;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.AdminSeeConsumer;
import com.loanlelo.LoanLeLe.Enum.LoanbyConsumer.Status;
import com.loanlelo.LoanLeLe.Repository.ConsumerRepo;
import com.loanlelo.LoanLeLe.Repository.LoanTakeByConsumerRepo;

@Service
public class AdminTakeActionOnConsumerData {

    private ConsumerRepo consumerRepo;
    private LoanTakeByConsumerRepo loanTakeByConsumerRepo;

    public AdminTakeActionOnConsumerData(ConsumerRepo consumerRepo, LoanTakeByConsumerRepo loanTakeByConsumerRepo) {
        this.consumerRepo = consumerRepo;
        this.loanTakeByConsumerRepo = loanTakeByConsumerRepo;
    }

    public List<AdminSeeConsumer> adminSeeConsumer() {
        return consumerRepo.adminSeeConsumers();
    }

    @Transactional
    public Boolean adminRejectLoan(Long loanId, String rejectReason) {
        Status newStatus = Status.REJECTED;
        loanTakeByConsumerRepo.adminRejectLoan(loanId, newStatus, rejectReason);
        return true;
    }

    @Transactional
    public Boolean adminActiveLoan(Long loanid) {
        Status newStatus = Status.ACTIVE;
        loanTakeByConsumerRepo.adminActivedLoan(loanid, newStatus);
        return true;
    }

    public Optional<AdminViewLoanData> adminViewLoanData(Long id) {
        return consumerRepo.fetchLoanDetailsById(id);
    }

}
