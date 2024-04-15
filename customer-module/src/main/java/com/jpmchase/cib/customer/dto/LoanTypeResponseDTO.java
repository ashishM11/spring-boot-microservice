package com.jpmchase.cib.customer.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanTypeResponseDTO {
    private String loanType;
    private String loanTypeDesc;
}
