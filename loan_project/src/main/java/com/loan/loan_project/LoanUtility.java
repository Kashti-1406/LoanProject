package com.loan.loan_project;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Logger;

/**
HousingLoan calculator formula :M = P [((i * ( 1+i)^N )) / ((( 1+i)^N - 1) ) ]
M = monthly payment, P = Principle ,N = number of payments, i= Monthly interest rate
* */
public class LoanUtility {

    static Logger log = Logger.getLogger(LoanUtility.class.getName());

    public static double  convertYearsToMonth(double numberOfYears){
        return ( numberOfYears * 12 );
    }

    public static String getCurrencyInEUR(double amountToConvert){
        NumberFormat number= NumberFormat.getCurrencyInstance();
        number.setCurrency(Currency.getInstance(Locale.GERMANY));
        return number.format(amountToConvert);
    }
    public static double calculateMonthlyRepayment(LoanDetails  loan){
        //log.info("In calculateMonthlyRepayment ");
        double monthlyPayment =0.0;
        try {
            double monthlyInterest = (loan.getRateOfInterestAnnual()) / (12 * 100);
            double principal = loan.getLoanAmount();
            double time = loan.getRepaymentMonths();
            double numberOfPayments = loan.getTotalNumberOfPayments();

            monthlyPayment = principal * (
                    monthlyInterest * (Math.pow((1 + monthlyInterest), numberOfPayments))) /
                    (Math.pow((1 + monthlyInterest), numberOfPayments) - 1
                    );
        }catch (ArithmeticException e){

            System.out.println("ERROR: Invalid number received for calculation of MonthlyRepayment !");
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("ERROR : Something went wrong in calculateMonthlyRepayment method !");
            e.printStackTrace();
        }
        return monthlyPayment;
    }

    public static double getTotalPaybackAmount(LoanDetails loan){
        double monthlyPayment = calculateMonthlyRepayment(loan);
        return  monthlyPayment * loan.getTotalNumberOfPayments();

    }
    public static double getGeneratedInterestForLoanAmount(LoanDetails loan){
        double totalPaybackAmount = getTotalPaybackAmount(loan);
        return totalPaybackAmount - loan.getLoanAmount();
    }
}
