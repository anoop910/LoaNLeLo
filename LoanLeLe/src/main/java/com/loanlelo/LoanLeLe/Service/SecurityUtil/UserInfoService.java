package com.loanlelo.LoanLeLe.Service.SecurityUtil;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.Entity.Admin;
import com.loanlelo.LoanLeLe.Entity.Company;
import com.loanlelo.LoanLeLe.Entity.Consumer;
import com.loanlelo.LoanLeLe.Repository.AdminRepo;
import com.loanlelo.LoanLeLe.Repository.CompanyRepo;
import com.loanlelo.LoanLeLe.Repository.ConsumerRepo;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    private ConsumerRepo consumerRepo;

    private AdminRepo adminRepo;

    private CompanyRepo companyRepo;

    public UserInfoService(ConsumerRepo consumerRepo, AdminRepo adminRepo, CompanyRepo companyRepo) {
        this.consumerRepo = consumerRepo;
        this.adminRepo = adminRepo;
        this.companyRepo = companyRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepo.findByEmail(username);
        if (admin.isPresent()) {
            Admin newAdmin = admin.get();
            return new User(
                    newAdmin.getEmail(),
                    newAdmin.getPassword(),
                    true, true, true, true,
                    Collections.singletonList(new SimpleGrantedAuthority(newAdmin.getRole())));
        }

        Optional<Consumer> consumer = consumerRepo.findByEmail(username);
        if (consumer.isPresent()) {
            Consumer newConsumer = consumer.get();
            return new User(
                    newConsumer.getEmail(),
                    newConsumer.getPassword(),
                    true, true, true, true,
                    Collections.singletonList(new SimpleGrantedAuthority(newConsumer.getRole())));
        }
        Optional<Company> company = companyRepo.findByBusinessEmail(username);
        if (company.isPresent()) {
            Company newCompany = company.get();
            return new User(
                    newCompany.getBusinessEmail(),
                    newCompany.getPassword(),
                    true, true, true, true,
                    Collections.singletonList(new SimpleGrantedAuthority(newCompany.getRole())));
        }

        throw new UsernameNotFoundException("User not found with email: " + username);
    }

}
