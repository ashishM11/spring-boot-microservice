package com.jpmchase.cib.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotEmpty(message = "First Name cannot be Empty.")
    @NotBlank(message = "First Name cannot be Blank.")
    @NotNull(message = "First Name cannot be Null.")
    private String custFname;

    @NotEmpty(message = "Last Name cannot be Empty.")
    @NotBlank(message = "Last Name cannot be Blank.")
    @NotNull(message = "Last Name cannot be Null.")
    private String custLname;

    @NotEmpty(message = "Mobile number cannot be Empty.")
    @NotBlank(message = "Mobile number cannot be Blank.")
    @NotNull(message = "Mobile number cannot be Null.")
    @Length(max = 10, min = 10, message = "Mobile Number should be of 10 digit.")
    private String custMobile;

    @NotEmpty(message = "Mail Id cannot be Empty.")
    @NotBlank(message = "Mail Id cannot be Blank.")
    @NotNull(message = "Mail Id cannot be Null.")
    private String custEmail;

    @NotEmpty(message = "Please share your gender.")
    private String custGender;

    @NotNull(message = "Branch Id is Required.")
    private Long branchId;

    private LocalDateTime custCreationDT;

}
