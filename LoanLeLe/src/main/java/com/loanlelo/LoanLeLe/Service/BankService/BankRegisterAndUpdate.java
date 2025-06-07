package com.loanlelo.LoanLeLe.Service.BankService;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loanlelo.LoanLeLe.DTO.BankDTO.BankRegister;
import com.loanlelo.LoanLeLe.DTO.BankDTO.CreateLoanByBank;
import com.loanlelo.LoanLeLe.DTO.BankDTO.GetBankByAdmin;
import com.loanlelo.LoanLeLe.Entity.Admin;
import com.loanlelo.LoanLeLe.Entity.Bank;
import com.loanlelo.LoanLeLe.Entity.LoanProvideByBank;
import com.loanlelo.LoanLeLe.Repository.AdminRepo;
import com.loanlelo.LoanLeLe.Repository.BankRepo;
import com.loanlelo.LoanLeLe.Repository.LoanProvideByBankRepo;

@Service
public class BankRegisterAndUpdate {
    private BankRepo bankRepo;
    private LoanProvideByBankRepo loanProvideByBankRepo;
    private AdminRepo adminRepo;

    

    public BankRegisterAndUpdate(BankRepo bankRepo, LoanProvideByBankRepo loanProvideByBankRepo, AdminRepo adminRepo) {
        this.bankRepo = bankRepo;
        this.loanProvideByBankRepo = loanProvideByBankRepo;
        this.adminRepo = adminRepo;
    }

    public BankRegister createBank(BankRegister bankRegister, UserDetails userDetails) {
        if (bankRegister != null) {
            String userName = userDetails.getUsername();
            Admin admin = adminRepo.findByEmail(userName).orElseThrow(()-> new UsernameNotFoundException("User not found by id :" + userName));
            Bank bank = new Bank();
            bank.setName(bankRegister.getName());
            bank.setAddress(bankRegister.getAddress());
            bank.setContactNumber(bankRegister.getContactNumber());
            bank.setEmail(bankRegister.getEmail());
            bank.setLicenseNumber(bankRegister.getLicenseNumber());
            bank.setAdmin(admin);
            bankRepo.save(bank);
            return bankRegister;
        }

        return null;
    }

    public CreateLoanByBank createLoanByBank(CreateLoanByBank createLoanByBank) {

        if (createLoanByBank != null) {
            String email = createLoanByBank.getBankEmail();
          
            Bank bank = bankRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Bank not found"));
            LoanProvideByBank newLoanProvideByBank = new LoanProvideByBank();
            newLoanProvideByBank.setName(createLoanByBank.getName());
            newLoanProvideByBank.setSubTitle(createLoanByBank.getSubTitle());
            newLoanProvideByBank.setInterestRate(createLoanByBank.getInterestRate());
            newLoanProvideByBank.setBank(bank);
            loanProvideByBankRepo.save(newLoanProvideByBank);
            return createLoanByBank;
        }
        return null;

    }

    public List<GetBankByAdmin> getBankByAdmin(UserDetails userDetails){
        String email = userDetails.getUsername();
        return bankRepo.findBankDetailsByAdminEmail(email);
    }

    public List<Bank> getAllbank(){
        return bankRepo.findAll();
    }

}
