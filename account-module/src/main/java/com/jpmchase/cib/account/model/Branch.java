package com.jpmchase.cib.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch implements Serializable {
    private String branchCode;
    private String branchAddress;
}
