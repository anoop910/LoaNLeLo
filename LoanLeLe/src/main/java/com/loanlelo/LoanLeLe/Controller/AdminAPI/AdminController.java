package com.loanlelo.LoanLeLe.Controller.AdminAPI;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminCreate;
import com.loanlelo.LoanLeLe.DTO.AdminDTO.AdminEmail;
import com.loanlelo.LoanLeLe.Entity.Admin;
import com.loanlelo.LoanLeLe.Repository.AdminRepo;
import com.loanlelo.LoanLeLe.Service.AdminService.AdminRegister;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminRepo adminRepo;

    private AdminRegister adminRegister;

    public AdminController(AdminRegister adminRegister) {
        this.adminRegister = adminRegister;
    }

    @PostMapping("/create")
    public AdminCreate adminCreates(@Valid @RequestBody AdminCreate adminCreate){
        return adminRegister.adminCreates(adminCreate);
    }

    @PostMapping("/get")
    public Optional<Admin> getS(@RequestBody AdminEmail adminEmail){
        return adminRepo.findByEmail(adminEmail.getEmail());
    }
    
}
