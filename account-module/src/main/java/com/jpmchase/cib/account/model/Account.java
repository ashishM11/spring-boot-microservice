package com.jpmchase.cib.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblAccount")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "accountNo")
    private String accountNo;

    @Column(name = "accountType", nullable = false)
    private String accountType;

    @Column(name = "accountBalance", nullable = false)
    private Double accountBalance;

    @Column(name = "accountCreationDT")
    private LocalDateTime accountCreationDT;

    @Column(name = "custId", nullable = false)
    private Long custId;

}
