package com.jpmchase.cib.loan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblLoan")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "loanAccountNo",nullable = false,unique = true)
    private String loanAccountNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "loanStartDate",nullable = false)
    private LocalDate loanStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "loanEndDate",nullable = false)
    private LocalDate loanEndDate;

    @Column(name = "loanTenureInMonths",nullable = false)
    private Integer loanTenureInMonths;

    @Column(name="loanRateOfInterest",nullable = false)
    private Float loanRateOfInterest;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="loanCreationDT", nullable = false)
    private LocalDateTime loanCreationDT;

    @Column(name="loanAmount", nullable = false)
    private Long loanAmount;

    @Column(name="loanPendingAmount", nullable = false)
    private Long loanPendingAmount;

    @Column(name = "custId", nullable = false)
    private Long custId;

    @ManyToOne
    @JoinColumn(name = "loanTypeId", nullable = false)
    private LoanType loanType;

}

