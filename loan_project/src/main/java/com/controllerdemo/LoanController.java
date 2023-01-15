package com.controllerdemo;

import com.loan.loan_project.LoanDetails;
import com.servicedemo.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="testAPI", description = "Testing swagger API")
@RestController
@RequestMapping("/loan")

public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping
    public ResponseEntity<LoanDetails> getLoanEMI(@RequestParam Double amount, @RequestParam Double years){
        LoanDetails l = loanService.getLoanEMI(amount,years);
        return new ResponseEntity<LoanDetails>(l,HttpStatus.OK);
    }
}
