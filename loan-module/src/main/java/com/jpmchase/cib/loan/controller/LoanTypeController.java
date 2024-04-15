package com.jpmchase.cib.loan.controller;

import com.jpmchase.cib.loan.dto.LoanResponseDTO;
import com.jpmchase.cib.loan.dto.LoanTypeRequestResponseDTO;
import com.jpmchase.cib.loan.service.LoanTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loanType")
@AllArgsConstructor
public class LoanTypeController {

    private final LoanTypeService loanTypeService;

    @GetMapping("/{loanType}")
    public ResponseEntity<List<LoanResponseDTO>> getLoanByLoanType(@PathVariable(value = "loanType")String loanType){
        return ResponseEntity.ok(loanTypeService.getAllLoanByLoanType(loanType));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LoanTypeRequestResponseDTO>> getAllLoanTypes(){
        return ResponseEntity.ok(loanTypeService.getAllLoanTypeList());
    }

}
