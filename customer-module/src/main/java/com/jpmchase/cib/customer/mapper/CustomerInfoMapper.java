package com.jpmchase.cib.customer.mapper;

import com.jpmchase.cib.customer.dto.AccountResponseDTO;
import com.jpmchase.cib.customer.dto.CustomerInfoResponseDTO;
import com.jpmchase.cib.customer.dto.CustomerResponseDTO;
import com.jpmchase.cib.customer.dto.LoanResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerInfoMapper {

    CustomerInfoMapper INSTANCE = Mappers.getMapper(CustomerInfoMapper.class);

    CustomerInfoResponseDTO fromAllInfoToCustomerInfoResponseDto(CustomerResponseDTO customer, List<AccountResponseDTO> accounts, List<LoanResponseDTO> loans);

}
