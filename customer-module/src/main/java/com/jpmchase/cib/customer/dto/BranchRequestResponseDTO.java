package com.jpmchase.cib.customer.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequestResponseDTO {

    @NotEmpty(message = "Branch Code Cannot be Empty.")
    private String branchCode;

    @NotEmpty(message = "Branch without Address does not exists.")
    private String branchAddress;

}
