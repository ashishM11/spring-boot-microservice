package com.jpmchase.cib.loan.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblLoanType")
public class LoanType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanTypeId;

    @Column(name = "loanType",nullable = false,unique = true)
    private String loanType;

    @Column(name = "loanTypeDesc",nullable = false)
    private String loanTypeDesc;

    @OneToMany(mappedBy = "loanType",fetch = FetchType.LAZY)
    @JsonBackReference
    Set<Loan> loanSet;
}
