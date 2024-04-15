package com.jpmchase.cib.customer.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblBranch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @Column(name = "branchCode", nullable = false, unique = true)
    private String branchCode;

    @Column(unique = true, nullable = false, name = "branchAddress")
    private String branchAddress;

    @Column(name = "branchCreationDT")
    private LocalDateTime branchCreationDT;

    @OneToMany(mappedBy = "branch",fetch = FetchType.LAZY)
    @JsonBackReference
    Set<Customer> customerSet;

}
