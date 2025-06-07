package com.loanlelo.LoanLeLe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanlelo.LoanLeLe.Entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    
    Optional<Admin> findByEmail(String email);

}
