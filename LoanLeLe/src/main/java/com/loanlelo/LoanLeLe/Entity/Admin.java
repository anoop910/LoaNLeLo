package com.loanlelo.LoanLeLe.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "admin")
    @JsonManagedReference
    private List<Bank> bank;


    @Override
    public String toString() {
        return "Admin [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
                + role + ", getEmail()=" + getEmail() + ", getId()=" + getId() + ", getPassword()=" + getPassword()
                + ", getRole()=" + getRole() + ", getUsername()=" + getUsername() + ", hashCode()=" + hashCode()
                + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
    }
}

