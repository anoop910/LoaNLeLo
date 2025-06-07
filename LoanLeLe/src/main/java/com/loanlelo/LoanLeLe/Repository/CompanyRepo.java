package com.loanlelo.LoanLeLe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanlelo.LoanLeLe.Entity.Company;


@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
      Optional<Company> findByEmail(String email);
}
