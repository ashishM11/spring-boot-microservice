package com.jpmchase.cib.loan.controller;

import com.jpmchase.cib.loan.dto.LoanRequestDTO;
import com.jpmchase.cib.loan.dto.LoanResponseDTO;
import com.jpmchase.cib.loan.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
@AllArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/customer/{custId}")
    public ResponseEntity<List<LoanResponseDTO>> getLoanByCustId(@PathVariable(value = "custId")Long custId){
        return ResponseEntity.ok(loanService.getAllLoansByCustId(custId));
    }

    @GetMapping("/{loanAccountNo}")
    public ResponseEntity<LoanResponseDTO> getLoanInfoByLoanAccountNo(@PathVariable(value="loanAccountNo") String loanAccountNo){
        return ResponseEntity.ok(loanService.findLoanByLoanAccountNo(loanAccountNo));
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewLoan(@RequestBody LoanRequestDTO requestDTO){
        return ResponseEntity.ok(loanService.saveLoanRequest(requestDTO));
    }
}
