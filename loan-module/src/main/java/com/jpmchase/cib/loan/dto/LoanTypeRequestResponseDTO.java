package com.jpmchase.cib.loan.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanTypeRequestResponseDTO {
    private String loanType;
    private String loanTypeDesc;
}
