# LoanProject



Loan Project Java app: 

1. Run main class LoanProjectConsoleApp.java
2. Provide Loan amount and years as an input throught console
3. result on console will be like :
Enter Loan amount : 138902
Enter repayment duration in years : 13
You Entered amount as : 138902 and for 13 Years ! 
LoanDetails{
 rateOfInterestAnnual=3.5,
 loanAmount=138902.0,
 repaymentYears=13.0,
 typeOfLoan=HOUSING_LOAN}
Your Monthly Payment is= €1,109.55
Total Pay back : €173,089.34
Total Pay back : €34,187.34

Loan Project as basic Rest WebService 

1. Run LoanProjectApplication.java as springboot application. 
2. wait untill server is up. 
3. Then go to browser / Postman tool and hit below URL.  As we are accepting 2 arguments from user we need to pass amount and years as request parameters. 
localhost:8080/HomeLoanApplication/loan?amount=100000&years=15 
4. Result will be like : 
{
    "rateOfInterestAnnual": 3.5,
    "loanAmount": 138902.0,
    "repaymentYears": 13.0,
    "typeOfLoan": "HOUSING_LOAN",
    "totalNumberOfPayments": 156.0,
    "monthlyPayment": 1109.55,
    "totalPauBackAmount": 173089.34,
    "repaymentMonths": 156.0
}