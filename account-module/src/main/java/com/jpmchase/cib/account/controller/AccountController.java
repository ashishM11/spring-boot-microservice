package com.jpmchase.cib.account.controller;

import com.jpmchase.cib.account.dto.AccountRequestDTO;
import com.jpmchase.cib.account.dto.AccountResponseDTO;
import com.jpmchase.cib.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/new")
    public ResponseEntity<String> newAccount(@RequestBody @Validated AccountRequestDTO requestDTO) {
        return new ResponseEntity<>(accountService.saveAccount(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{acctNo}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable(value = "acctNo") String acctNo) {
        return new ResponseEntity<>(accountService.getAccountByAcctNo(acctNo), HttpStatus.OK);
    }

    @GetMapping("/customer/{custId}")
    public ResponseEntity<List<AccountResponseDTO>> getAccountsByCustId(@PathVariable(value = "custId") Long custId){
        return ResponseEntity.ok(accountService.getAccountsByCustId(custId));
    }
}