package com.jpmchase.cib.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponseDTO {
    private Long loanId;
    private String loanAccountNo;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private String loanTenureInMonths;
    private Float loanRateOfInterest;
    private Long loanAmount;
    private Long loanPendingAmount;
    private LocalDateTime loanCreationDT;
    private LoanTypeResponseDTO loanType;
}
