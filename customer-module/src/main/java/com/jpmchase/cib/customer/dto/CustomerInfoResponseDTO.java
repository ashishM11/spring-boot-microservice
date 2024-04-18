package com.jpmchase.cib.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoResponseDTO {

    private CustomerResponseDTO customer;
    private List<AccountResponseDTO> accounts;
    private List<LoanResponseDTO> loans;
    private String errorResponse;
}
