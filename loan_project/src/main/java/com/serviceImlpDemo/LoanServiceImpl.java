package com.serviceImlpDemo;

import com.loan.loan_project.LoanDetails;
import com.loan.loan_project.LoanUtility;
import com.loan.loan_project.TypesOfLoan;
import com.servicedemo.LoanService;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service

public class LoanServiceImpl implements LoanService {
    static Logger log = Logger.getLogger(LoanServiceImpl.class.getName());

    @Override
    public LoanDetails getLoanEMI(Double amount, Double years) {

        log.info("Requested amount is : " + amount + " and for " + years + " Years ! ");

        // Collect data from user and put in one object
        LoanDetails loan = new LoanDetails(amount, years, TypesOfLoan.HOUSING_LOAN);
        log.info("Loan Object : "+ loan);
        // Calculate monthly payment amount for your loan
        double monthlyPayment = LoanUtility.calculateMonthlyRepayment(loan);
        loan.setMonthlyPayment(monthlyPayment);
        log.info("Your Monthly Payment is= " + LoanUtility.getCurrencyInEUR(monthlyPayment));

        //Total payback amount for given number of years
        double totalPayBackAmount = LoanUtility.getTotalPaybackAmount(loan);
        loan.setTotalPauBackAmount(totalPayBackAmount);
        log.info("Total Pay back : " + LoanUtility.getCurrencyInEUR(totalPayBackAmount));

        //Generated Interest
        double generatedInterestForLoan = LoanUtility.getGeneratedInterestForLoanAmount(loan);
        log.info("Total Pay back : " + LoanUtility.getCurrencyInEUR(generatedInterestForLoan));
        return loan;


    }
}
