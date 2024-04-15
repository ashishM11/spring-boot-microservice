package com.jpmchase.cib.account.mapper;

import com.jpmchase.cib.account.dto.CustomerResponseDTO;
import com.jpmchase.cib.account.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerResponseDTO fromCustomerToCustomerResponseDto(Customer customer);
}
