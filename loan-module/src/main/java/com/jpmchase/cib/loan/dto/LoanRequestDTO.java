package com.jpmchase.cib.loan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequestDTO {

    private String loanAccountNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate loanStartDate;
    private Integer loanTenureInMonths;
    private Long loanTypeId;
    private Float loanRateOfInterest;
    private Long loanAmount;
    private Long loanPendingAmount;
    private Long custId;
}
