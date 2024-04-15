package com.jpmchase.cib.customer.controller;

import com.jpmchase.cib.customer.dto.BranchRequestResponseDTO;
import com.jpmchase.cib.customer.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
@AllArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/all")
    public ResponseEntity<List<BranchRequestResponseDTO>> getAllCustomers() {
        return new ResponseEntity<>(branchService.getAllBankBranch(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<BranchRequestResponseDTO> saveCustomer(@RequestBody BranchRequestResponseDTO requestDTO) {
        return new ResponseEntity<>(branchService.saveBankBranch(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/customer/{custId}")
    public ResponseEntity<BranchRequestResponseDTO> getBranchByBranchId(@PathVariable(value = "custId") Long custId) {
        return new ResponseEntity<>(branchService.getBranchByCustId(custId), HttpStatus.OK);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<BranchRequestResponseDTO> getBranchByItsId(@PathVariable(value = "branchId") Long branchId){
        return new ResponseEntity<>(branchService.getBranchByItsId(branchId), HttpStatus.OK);
    }

}
