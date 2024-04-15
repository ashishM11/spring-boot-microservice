package com.jpmchase.cib.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblCustomer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    @Column(nullable = false, length = 25, name = "custFname")
    private String custFname;

    @Column(nullable = false, length = 25, name = "custLname")
    private String custLname;

    @Column(nullable = false, length = 50, name = "custEmail")
    private String custEmail;

    @Column(nullable = false, length = 10, name = "custMobile")
    private String custMobile;

    @Column(nullable = false, length = 50, name = "custGender")
    private String custGender;

    @Column(name = "custCreationDT")
    private LocalDateTime custCreationDT;

    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;

}
