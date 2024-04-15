package com.jpmchase.cib.customer.controller;

import com.jpmchase.cib.customer.dto.CustomerInfoResponseDTO;
import com.jpmchase.cib.customer.dto.CustomerRequestDTO;
import com.jpmchase.cib.customer.dto.CustomerResponseDTO;
import com.jpmchase.cib.customer.model.Branch;
import com.jpmchase.cib.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable(value = "custId") String custId) {
        return new ResponseEntity<>(customerService.getCustomerById(Long.valueOf(custId)), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO requestDTO) {
        return new ResponseEntity<>(customerService.saveCustomer(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/allInfo/{custId}")
    public ResponseEntity<CustomerInfoResponseDTO> fetchCustomerAllInfo(@PathVariable(value = "custId") Long custId){
        return ResponseEntity.ok(customerService.getCustomerAllInfo(custId));
    }


}
