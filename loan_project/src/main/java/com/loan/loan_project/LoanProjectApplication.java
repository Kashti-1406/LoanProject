package com.loan.loan_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.*")
public class LoanProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoanProjectApplication.class, args);
    }

}
