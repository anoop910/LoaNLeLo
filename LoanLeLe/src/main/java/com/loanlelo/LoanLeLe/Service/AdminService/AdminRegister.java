package com.loanlelo.LoanLeLe.Service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminCreate;
import com.loanlelo.LoanLeLe.Entity.Admin;
import com.loanlelo.LoanLeLe.Repository.AdminRepo;

@Service
public class AdminRegister {
    
    
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminRegister(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
        
    }

    @Transactional
    public AdminCreate adminCreates(AdminCreate adminCreate){
        Admin admin = new Admin();

        admin.setEmail(adminCreate.getEmail());
        admin.setPassword(passwordEncoder.encode(adminCreate.getPassword()));
        admin.setUsername(adminCreate.getUsername());
        admin.setRole("ROLE_ADMIN");
        adminRepo.save(admin);
        return adminCreate;
    }

}
