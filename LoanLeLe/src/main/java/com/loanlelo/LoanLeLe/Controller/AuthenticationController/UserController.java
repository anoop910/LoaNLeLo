package com.loanlelo.LoanLeLe.Controller.AuthenticationController;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.web.bind.annotation.*;

import com.loanlelo.LoanLeLe.DTO.AuthDTO.AuthRequest;
import com.loanlelo.LoanLeLe.Service.SecurityUtil.JwtService;

@RestController
@RequestMapping("/auth")
public class UserController {

    private JwtService jwtService;

    private AuthenticationManager authenticationManager;

    public UserController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/user/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}