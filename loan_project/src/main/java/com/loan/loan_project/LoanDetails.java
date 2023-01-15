package com.loan.loan_project;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
@Component
public class LoanDetails {


    private double rateOfInterestAnnual;
    private double loanAmount;
    private double repaymentYears;

    private TypesOfLoan typeOfLoan;

    private double totalNumberOfPayments;
    private BigDecimal monthlyPayment;
    private BigDecimal totalPauBackAmount;

    public LoanDetails(){}
    public LoanDetails(double amount, double years, TypesOfLoan type){
        loanAmount = amount;
        repaymentYears=years;
        typeOfLoan=type;
        setRateOfInterestAnnual();
        setTotalNumberOfPayments();
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getRepaymentYears() {
        return repaymentYears;
    }

    public TypesOfLoan getTypeOfLoan() {
        return typeOfLoan;
    }

    public double getRateOfInterestAnnual() {
        return rateOfInterestAnnual;
    }

    public void setRateOfInterestAnnual() {
        this.rateOfInterestAnnual = TypesOfLoan.HOUSING_LOAN.getRateOfInterest();
    }

    public void setTypeOfLoan(TypesOfLoan typeOfLoan) {
        this.typeOfLoan = typeOfLoan;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setRepaymentYears(double repaymentYears) {
        this.repaymentYears = repaymentYears;
    }
    public double getRepaymentMonths(){
        return LoanUtility.convertYearsToMonth(repaymentYears) ;
    }

    public double getTotalNumberOfPayments() {
        return totalNumberOfPayments;
    }

    public void setTotalNumberOfPayments() {
        this.totalNumberOfPayments = repaymentYears * 12;
    }

    public double getMonthlyPayment() {
        return monthlyPayment.doubleValue();
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = new BigDecimal(monthlyPayment).setScale(2, RoundingMode.HALF_UP);
    }

    public double getTotalPauBackAmount() {
        return totalPauBackAmount.doubleValue();
    }

    public void setTotalPauBackAmount(double totalPauBackAmount) {
        this.totalPauBackAmount  = new BigDecimal(totalPauBackAmount).setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanDetails)) return false;
        LoanDetails that = (LoanDetails) o;
        return Double.compare(that.getRateOfInterestAnnual(), getRateOfInterestAnnual()) == 0 && Double.compare(that.getLoanAmount(), getLoanAmount()) == 0 && Double.compare(that.getRepaymentYears(), getRepaymentYears()) == 0 && getTypeOfLoan() == that.getTypeOfLoan();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRateOfInterestAnnual(), getLoanAmount(), getRepaymentYears(), getTypeOfLoan());
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "\n rateOfInterestAnnual=" + rateOfInterestAnnual +
                ",\n loanAmount=" + loanAmount +
                ",\n repaymentYears=" + repaymentYears +
                ",\n typeOfLoan=" + typeOfLoan +
                '}';
    }
}

