package com.jpmchase.cib.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {
    private String accountNo;
    private String accountType;
    private double accountBalance;
    private Long custId;
    private LocalDateTime accountCreationDT;
}
//9619056636