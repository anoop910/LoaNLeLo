package com.loanlelo.LoanLeLe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.loanlelo.LoanLeLe")
public class LoanLeLeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanLeLeApplication.class, args);
	}

}
