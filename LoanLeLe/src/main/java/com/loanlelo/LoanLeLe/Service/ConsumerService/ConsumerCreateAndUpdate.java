package com.loanlelo.LoanLeLe.Service.ConsumerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerCreate;
import com.loanlelo.LoanLeLe.DTO.ConsumerDTO.ConsumerGetForLoan;
import com.loanlelo.LoanLeLe.Entity.Consumer;
import com.loanlelo.LoanLeLe.Repository.ConsumerRepo;

@Service
public class ConsumerCreateAndUpdate {

    private ConsumerRepo consumerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ConsumerCreateAndUpdate(ConsumerRepo consumerRepo) {
        this.consumerRepo = consumerRepo;
    }

    public ConsumerCreate createConsumer(ConsumerCreate consumerCreate) {
        if (consumerCreate != null) {
            Consumer consumer = new Consumer();
            consumer.setEmail(consumerCreate.getEmail());
            consumer.setPassword(passwordEncoder.encode(consumerCreate.getPassword()));
            consumer.setFirstName(consumerCreate.getFirstName());
            consumer.setLastName(consumerCreate.getLastName());
            consumer.setPhone(consumerCreate.getPhone());
            consumer.setRole("ROLE_USER");

            consumerRepo.save(consumer);
            return consumerCreate;
        }
        return null;
    }

    public ConsumerGetForLoan getConsumer(UserDetails userDetails) {
        String email = userDetails.getUsername();
        return consumerRepo.findConsumerGetForLoanByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found" + email));
    }

    public List<Consumer> getAllConsumer() {
        return consumerRepo.findAll();
    }

}
