package com.loan.loan_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class LoanProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanProjectApplication.class, args);
		System.out.println("Hello");

		try(Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter Loan amount : ");
			int amountOfLoan = scan.nextInt();
			System.out.print("Enter repayment duration in years : ");
			int repaymentYears = scan.nextInt();

			System.out.println("You Entered amount as : " + amountOfLoan + " and for " + repaymentYears + " Years ! ");

			// Collect data from user and put in one object
			LoanDetails loan = new LoanDetails(amountOfLoan, repaymentYears, TypesOfLoan.HOUSING_LOAN);
			System.out.println(loan);
			// Calculate monthly payment amount for your loan
			double monthlyPayment = LoanUtility.calculateMonthlyRepayment(loan);
			System.out.println("Your Monthly Payment is= " + NumberFormat.getCurrencyInstance().format(monthlyPayment));

			//Total payback amount for given number of years
			double totalPauBackAmount = LoanUtility.getTotalPaybackAmount(monthlyPayment,loan);
			System.out.println("Total Pay back : " + (NumberFormat.getCurrencyInstance().format(totalPauBackAmount)));

		}catch(InputMismatchException e){
			System.out.println("Provided invalid input!");
		}
		catch (Exception e){
			System.out.println("Something went wrong in calculateMonthlyRepayment method !");
			e.printStackTrace();
		}


	}

}
