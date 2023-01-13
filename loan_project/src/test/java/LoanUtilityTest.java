import com.loan.loan_project.LoanDetails;
import com.loan.loan_project.LoanUtility;
import com.loan.loan_project.TypesOfLoan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanUtilityTest {

    @Test
    public void calculateMonthlyRepaymentTest(){

        // check for zero monthlypayment, that is invalid
        LoanDetails loan1 = new LoanDetails(12000, 15, TypesOfLoan.HOUSING_LOAN);
        double result= LoanUtility.calculateMonthlyRepayment(loan1);
        Assertions.assertNotEquals(result,0.0);
        System.out.println("In JUnit Test class !");
    }
}

