package com.servicedemo;

import com.loan.loan_project.LoanDetails;

public interface LoanService {
    public LoanDetails getLoanEMI(Double amount, Double years);
}
