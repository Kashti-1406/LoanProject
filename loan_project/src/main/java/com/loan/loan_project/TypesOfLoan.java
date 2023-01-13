package com.loan.loan_project;

public enum TypesOfLoan {

    HOUSING_LOAN(3.5);
    private double rateOfInterest;

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    TypesOfLoan(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }
}
